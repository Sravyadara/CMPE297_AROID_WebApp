package controllers;

import play.*;

import play.data.Form;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import views.html.*;
import views.productFormData.ProductForm;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.nio.ByteBuffer;

import org.jongo.Aggregate;
import org.jongo.Aggregate.ResultsIterator;
import org.jongo.Jongo;
import org.jongo.MongoCursor;

import models.SignUpForm;
import models.Users;
import models.LoginForm;
import models.ProductDetails;
import models.Products;
import uk.co.panaxiom.playjongo.*;

public class Application extends Controller {

	public  String status = "success";

	public List<String> list;
	public List<String> names;

	public Result index() {
		return ok(index.render("Hello :)"));
	}

	// Sravya Dara's Additions

	public Result adminRetailerCatalog() {
		if(session("username") != null) {
			return ok(adminRetailerCatalog.render("Your new application is ready."));
		}else {
			status = "success";
			return viewLogin();
		}

	}

	public Result viewSignUpForm(){
		Form<SignUpForm> signUpForm = Form.form(SignUpForm.class);
		return ok(signup.render(signUpForm));
	}

	public Result signUp(){
		Form<SignUpForm> signUp = Form.form(SignUpForm.class);
		SignUpForm form = signUp.bindFromRequest().get();
		System.out.println(form.getFirstName());
		System.out.println(form.getRole());
		Users newUser = new Users(form.getFirstName(),
				form.getLastName(), form.getRole(),
				form.getEmailId(),  form.getContactNum(),
				form.getUserName(), form.getPassword(),
				form.getRetailer(), "pending");

		System.out.println(newUser.userName);
		newUser.insert();
		return viewLogin();

	}

	public Result imageCatalog(String id) {
		if(session("username") != null) {
			Products prod = new Products();
			MongoCursor<Products> cursor = prod.findall();
			List<ProductDetails> details = new ArrayList<ProductDetails>();
			while (cursor.hasNext()) {
				List<ProductDetails> temp = cursor.next().products;
				for (ProductDetails pd : temp) {
					if (pd.getRetailer().equalsIgnoreCase(id)) {
						System.out.println("printing images");
						System.out.println(pd.getImage());
						details.add(pd);
					}
				}
			}
			return ok(catalogImagesA.render(id, details));
		}else {
			status = "success";
			return viewLogin();
		}
	}

	public Result adminInbox() {
		if(session("username") != null) {
			Users users = new Users();
			MongoCursor<Users> cursor = users.findByStatus("pending");
			List<Users> userlist = new ArrayList<Users>();
			while(cursor.hasNext()){
				userlist.add(cursor.next());
			}

			return ok(adminInbox.render(userlist));
		}else {
			status = "success";
			return viewLogin();
		}
	}

	public Result updateUserStatus(String status,String userName){
		System.out.println(status);
		System.out.println(userName);
		System.out.println("inside loop");
		Users users = new Users();
		users = Users.findById(userName);
		System.out.println(users.lastName);
		users.status = status;
		users.update();
		return adminInbox();

	}


	// Susmitha's additions

	public Result viewLogin() {
		Form<LoginForm> formData = Form.form(LoginForm.class);
		System.out.println("Status variable : " + status);
		return ok(login.render(formData,status));
	}

	public Result login() {
		Form<LoginForm> userForm = Form.form(LoginForm.class);
		LoginForm login = userForm.bindFromRequest().get();

		//UserInfo userInfo = UserInfo.findByName(user.getUsername())
		System.out.println("Current user session: "+ login.getUsername());
		System.out.println("user password : " + login.getPassword());
		session("username", login.getUsername());

		Users user = Users.findByName(login.getUsername(), login.getPassword());
		System.out.println("User value : " + user);
		if(user != null) {
			if(user.role.equalsIgnoreCase("admin")){
				return ok(adminRetailerCatalog.render("Your new application is ready."));
			}else if(user.role.equalsIgnoreCase("retailer")){
				session("retailerName", user.retailer);
				return showRetailerCategories();
			}else if(user.role.equalsIgnoreCase("customer")){
				return listofCategories();
			}

		}else {
			System.out.println("Invalid Credentials");
			status = "failed";
			return viewLogin();
		}
		return ok();
	}

	public Result logout() {
		session().clear();
		System.out.println("Session username : " + session("username"));
		System.out.println("Session retailer name : " + session("retailerName"));
		status = "relogin";
		return viewLogin();
	}


	public Result showProductFormData() {
		System.out.println("Inside show form");
		Form<ProductForm> formData = Form.form(ProductForm.class);
		if(session("retailerName") != null) {
			return ok(retailer_add_product.render(session("retailerName"),formData));
		}else {
			status = "success";
			return viewLogin();
		}
	}

	public Result showRetailerCategories(){

		Products p = new Products();

		// Fetching categories list
		List<String> categoryArray = p.getCategories("categoryname");
		if(session("retailerName") != null) {
			return ok(retailer_categories.render(session("retailerName"), categoryArray));
		}else {
			status = "success";
			return viewLogin();
		}
	}

	public String shortUUID() {
		UUID uuid = UUID.randomUUID();
		long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
		return Long.toString(l, Character.MAX_RADIX);
	}

	public Result postProductFormData() {
		Products p = new Products();
		String cn = "";
		System.out.println("In post function");
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart fpqr = body.getFile("qrcodefiled");
		FilePart fpwt3 = body.getFile("imagefiled");
		File qrfile,imagefile;
		String qrfileName, imagefileName, qrUrl, imageUrl;
		if (fpqr != null && fpwt3 != null) {
			qrfileName = fpqr.getFilename();
			imagefileName = fpwt3.getFilename();
			String contentType = fpqr.getContentType(); 
			String wt3COntentType = fpwt3.getContentType();
			qrfile = fpqr.getFile();
			imagefile = fpwt3.getFile();
			/*S3Handler s3handler = new S3Handler();
			qrUrl = s3handler.uploadImageFile(qrfile, qrfileName);
			imageUrl = s3handler.uploadImageFile(imagefile, imagefileName);*/
			qrUrl = "";
			imageUrl = "";
			System.out.println("Printing qr url : " + qrUrl);
			System.out.println("Printing qr url : " + imageUrl);

			ProductForm data = Form.form(ProductForm.class).bindFromRequest().get();
			cn = data.productCategory;
			String productId = cn.toLowerCase().substring(0, 1) + "-" + shortUUID();
			System.out.println("Category Value cn : " + cn);
			if(p.findCategory(data.productCategory) != null){
				p.updateCategory(productId, data.productCategory, data.productName, data.productDescription, data.productType, data.productPrice, qrUrl, imageUrl, session("retailerName"));
			}else {
				List<ProductDetails> productDetailsArray = new ArrayList<ProductDetails>();
				ProductDetails productDetails = new ProductDetails();
				productDetails.setProductid(productId);
				productDetails.setName(data.productName);
				productDetails.setDescription(data.productDescription);
				productDetails.setPrice(data.productPrice);
				productDetails.setQrcode(qrUrl);
				productDetails.setImage(imageUrl);
				productDetails.setRetailer(session("retailerName"));
				productDetailsArray.add(productDetails);
				p.categoryname = data.productCategory;
				p.products = productDetailsArray;
				p.insert();
			}
		}

		return showRetailerProducts(cn);
	}	


	public Result showRetailerProducts(String categoryName){

		//fetching products list for specific retailer.
		if(session("retailerName") != null) {
			MongoCursor<Products> cursor = Products.findByName(categoryName);
			List<ProductDetails> filteredProductDetails = new ArrayList<ProductDetails>();
			while(cursor.hasNext()){
				List<ProductDetails> details = cursor.next().products;
				for(ProductDetails d : details) {
					if(d.retailer.equalsIgnoreCase(session("retailerName"))){
						filteredProductDetails.add(d);
					}
				}
			}		
			return ok(retailer_products.render(session("retailerName"), filteredProductDetails));
		}else {
			status = "success";
			return viewLogin();
		}
	}

	// Sravya Reddy Additions

	public Result listofCategories(){

		if(session("username") != null) {
			Products p = new Products();
			System.out.println("Printng number of rows in products collections : " + p.getCount() + " and " + p.findall().count() );
			MongoCursor<Products> mongoCursor = p.findall();
			List<String> categoryArray = p.getCategories("categoryname");
			System.out.println("Printing Distinct values : " + p.getCategories("categoryname").size());
			for(String s : p.getCategories("categoryname")) {
				System.out.println("Category : "+ s);
			}
			List<ProductDetails> recommendedProductsList = getRecommendations();
			System.out.println("Count of recommended items : " + recommendedProductsList.size() );
			return ok(users_main.render(session("username").toUpperCase(), categoryArray, recommendedProductsList));
		}else {
			status = "success";
			return viewLogin();
		}
	}


	public Result listofProducts(String categoryname){
		if(session("username") != null) {
			Products p = new Products();
			MongoCursor<Products> m = p.findByName(categoryname);
			List<ProductDetails> proddetails = new ArrayList<ProductDetails>();
			while(m.hasNext()){

				List<ProductDetails> productDetails  = m.next().products;
				for(ProductDetails pd : productDetails){
					String name = pd.getName();
					String url= pd.getQrcode();
					String prdid=pd.getProductid();
					proddetails.add(pd);
				}
			}
			return ok(user_products.render(session("username").toUpperCase(), proddetails));
		}else {
			status = "success";
			return viewLogin();
		}
	}
	//Sravya Reddy
	public Result productdetailsfunc(String categoryname, String prdid,String liked){

		if(session("username") != null) {
			//int prodid =Integer.parseInt(prdid);
			System.out.println("&&& Inside productdetailsfunction &&&");
			String retailer="";
			String description="";
			String price="";
			String imageurl= "";
			String qrcode="";
			String name="";
			String type="";//---for similar items
			String productid="";
			String like="visible";
			Products p = new Products();
			MongoCursor<Products> m = p.findByName(categoryname);
			while(m.hasNext()){

				List<ProductDetails> prodDetails  = m.next().products;
				System.out.println(" After prodDetails :*******" + prodDetails.size());
				for(ProductDetails pd : prodDetails){


					if(pd.getProductid().equalsIgnoreCase(prdid))
					{ 	
						productid=pd.getProductid();
						retailer = pd.getRetailer();
						description = pd.getDescription();
						price = Integer.toString(pd.getPrice());
						imageurl= pd.getImage();
						qrcode= pd.getQrcode();
						name = pd.getName();
						type = pd.getType();
						System.out.println("Inside product details type : "+ type);
						String message = 	description +"/"+ price +"/"+ retailer;
						System.out.println("Message : " + message);


						String username=session("username");
						System.out.println("User from session: "+username);
						Users users = new Users();
						users = Users.findById(username);
						List<String> interestedItems = users.interested;
						for(String likeItem:interestedItems){
							if(likeItem.equalsIgnoreCase(productid)){
								like="disabled";
								System.out.println("------Already Liked-------");
							}
						}

					}
				}
			}

			Products p1 = new Products();
			MongoCursor<Products> m1 = p1.findByName(categoryname);
			List<ProductDetails> proddetails = new ArrayList<ProductDetails>();
			while(m1.hasNext()){

				List<ProductDetails> productDetails1  = m1.next().products;
				for(ProductDetails pd : productDetails1){

					System.out.println(" Inside carousal function ");
					if((pd.getType().equalsIgnoreCase(type)) && !pd.getProductid().equalsIgnoreCase(prdid)){
						proddetails.add(pd);
						System.out.println(" Inside carousal if condition ");
						System.out.print(" product type: " + pd.type + "product ID: " +pd.productid);
					}
					//proddetails.add(pd);
				}
			}
			if(liked.equalsIgnoreCase("true")){
				System.out.println("****Liked*******");	
				String username=session("username");
				System.out.println("User from session: "+username);
				Users users = new Users();
				users = Users.findById(username);
				System.out.println("Interested list size: "+users.interested.size());
				users.interested.add(prdid);
				users.update();
				like="disabled";


			}
			return ok(product_screen.render(session("username").toUpperCase(),productid,description,price,retailer,imageurl,qrcode,name,proddetails,like));
		}else {
			status = "success";
			return viewLogin();
		}
	}
	//Sravya Reddy
	/*public void likeFunctionPressed(String likedItem){
		System.out.println("Liked*******");
		//return ok();

	}*/
	public Result searchfunc(String categoryname,String searchvalue){

		if(session("username") != null) {

			List<ProductDetails> searchdetails = new ArrayList<ProductDetails>();

			Products p = new Products();
			MongoCursor<Products> m = p.findByName(categoryname);
			while(m.hasNext()){
				List<ProductDetails> prodDetails  = m.next().products;
				for(ProductDetails pd : prodDetails){
					String thisName = pd.getName();
					String thisDesc = pd.getDescription();
					String thisRet = pd.getRetailer();
					String matchMe = "(?i).*"+searchvalue+ ".*";
					if (thisName.matches(matchMe) || thisDesc.matches(matchMe) ||
							thisRet.matches(matchMe))
					{
						searchdetails.add(pd);
					}
				}

			}
			return ok(user_products.render(session("username").toUpperCase(),searchdetails));
		}else {
			status = "success";
			return viewLogin();
		}
	}

	public List<ProductDetails> getRecommendations() {
		System.out.println("Current logged user : " + session("username"));
		String loggedUser = session("username");
		Users otherUsers = new Users();
		Users currentUser = new Users();
		currentUser = Users.findById(loggedUser);
		MongoCursor<Users> othersResult = otherUsers.findOtherUsers(loggedUser);
		System.out.println("Printing count of result : " + othersResult.count());
		ArrayList<String> currentUserInterested = currentUser.interested;
		Set<String> recommendationSet = new HashSet<String>();
		while(othersResult.hasNext()) {
			ArrayList<String> othersInterested = othersResult.next().interested;
			ArrayList<String> tempCurrentUserInterested = new ArrayList<String>(currentUserInterested);
			if( (othersInterested.size() > 0) && (findMatchPercentage(tempCurrentUserInterested, othersInterested) > 30) ) {
				//System.out.println("Calling for user : " + othersResult.next().userName);
				System.out.println("Adding user to set");
				recommendationSet.addAll(othersInterested);
			}
		}

		System.out.println("Printing my hash set value : " + recommendationSet);
		recommendationSet.removeAll(currentUserInterested);
		System.out.println("Printing after hash set value : " + recommendationSet);
		Iterator iterator = recommendationSet.iterator();
		List<ProductDetails> productDetailsArray = new ArrayList<ProductDetails>();
		while(iterator.hasNext()) {
			String pid = (String) iterator.next();
			System.out.println("Iterator current item : " + pid);

			Iterable<Products> rsi = Products.findProduct(pid);
			while(rsi.iterator().hasNext()) {
				System.out.println("----------- Inside rsi -----------");
				Products pd = rsi.iterator().next();
				productDetailsArray.add(pd.products.get(0));
			}
		}
		return productDetailsArray;
	}

	public int findMatchPercentage(ArrayList<String> c, ArrayList<String> o) {
		int initialSize = c.size();
		c.retainAll(o);
		if(c.size() > 0) {
			int matchPercentage = (int) (100 * (c.size() * 1.0 / initialSize ));
			return matchPercentage; 
		}
		return 0;
	}

}
