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
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.jongo.Aggregate;
import org.jongo.Aggregate.ResultsIterator;
import org.jongo.Jongo;
import org.jongo.MongoCursor;

import models.Users;
import models.LoginForm;
import models.ProductDetails;
import models.Products;
import uk.co.panaxiom.playjongo.*;

public class Application extends Controller {

	public List<String> list;
	public List<String> names;
	
	public Result index() {
		return ok(index.render("Hello :)"));
	}

	// Sravya Dara's Additions
	
	public Result adminRetailerCatalog() {
		return ok(adminRetailerCatalog.render("Your new application is ready."));

	}

	public Result imageCatalog(String id) {
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

	}

	public Result adminInbox() {
	 Users users = new Users();
	 MongoCursor<Users> cursor = users.findByStatus("pending");
	 List<Users> userlist = new ArrayList<Users>();
	 while(cursor.hasNext()){
		 userlist.add(cursor.next());
	 }
	
		return ok(adminInbox.render(userlist));
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
		return ok(login.render(formData));
	}

	public Result login() {
		Form<LoginForm> userForm = Form.form(LoginForm.class);
		LoginForm login = userForm.bindFromRequest().get();

		//UserInfo userInfo = UserInfo.findByName(user.getUsername())
		System.out.println("Current user session: "+ login.getUsername());
//		if(session("username") == null){
//			session("username", login.getUsername());
//		}
		String result = Users.findByName(login.getUsername(), login.getPassword());
		if(!result.equalsIgnoreCase("Invalid")) {
			
			if(result.equalsIgnoreCase("admin")){
				
				return ok(adminRetailerCatalog.render("Your new application is ready."));
			}else if(result.equalsIgnoreCase("retailer")) {
				
				return showRetailerCategories();
			}else if(result.equalsIgnoreCase("customer")) {
				return listofCategories();
			}
		}else {
			System.out.println("Invalid Credentials");
			return viewLogin();
		}
		return ok();
	}
	
//	public Result logout() {
//		
//        
//        session().clear();
//        return ok(login.render("Your new application is ready."));
//	}


	public Result showProductFormData() {
		System.out.println("Inside show form");
		Form<ProductForm> formData = Form.form(ProductForm.class);
		return ok(retailer_add_product.render(formData));
	}

	public Result showRetailerCategories(){

		Products p = new Products();

		// Fetching categories list
		List<String> categoryArray = p.getCategories("categoryname");

		return ok(retailer_categories.render(categoryArray));
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
			S3Handler s3handler = new S3Handler();
			qrUrl = s3handler.uploadImageFile(qrfile, qrfileName);
			imageUrl = s3handler.uploadImageFile(imagefile, imagefileName);
			System.out.println("Printing qr url : " + qrUrl);
			System.out.println("Printing qr url : " + imageUrl);

			ProductForm data = Form.form(ProductForm.class).bindFromRequest().get();
			cn = data.productCategory;
			UUID productId = UUID.randomUUID();
			if(p.findCategory(data.productCategory) != null){
				p.updateCategory(productId, data.productCategory, data.productName, data.productDescription, data.productPrice, qrUrl, imageUrl);
			}else {
				List<ProductDetails> productDetailsArray = new ArrayList<ProductDetails>();
				ProductDetails productDetails = new ProductDetails();
				productDetails.setProductid(productId.toString());
				productDetails.setName(data.productName);
				productDetails.setDescription(data.productDescription);
				productDetails.setPrice(data.productPrice);
				productDetails.setQrcode(qrUrl);
				productDetails.setImage(imageUrl);
				productDetails.setRetailer("ikea");
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

		MongoCursor<Products> cursor = Products.findByName(categoryName);
		List<ProductDetails> filteredProductDetails = new ArrayList<ProductDetails>();
		while(cursor.hasNext()){
			List<ProductDetails> details = cursor.next().products;
			for(ProductDetails d : details) {
				if(d.retailer.equalsIgnoreCase("ikea")){
					filteredProductDetails.add(d);
				}
			}
		}

		return ok(retailer_products.render(filteredProductDetails));
	}

	// Sravya Reddy Additions

	public Result listofCategories(){

		Products p = new Products();
		System.out.println("Printng number of rows in products collections : " + p.getCount() + " and " + p.findall().count() );
		MongoCursor<Products> mongoCursor = p.findall();
		List<String> categoryArray = p.getCategories("categoryname");
		System.out.println("Printing Distinct values : " + p.getCategories("categoryname").size());
		for(String s : p.getCategories("categoryname")) {
			System.out.println("Category : "+ s);
		}

		return ok(users_main.render(categoryArray));
	}


	public Result listofProducts(String categoryname){
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
		return ok(user_products.render(proddetails));
	}

	public Result productdetailsfunc(String categoryname, String prdid){
		//int prodid =Integer.parseInt(prdid);
		String retailer="";
		String description="";
		String price="";
		String imageurl= "";
		String qrcode="";
		String name="";

		Products p = new Products();
		MongoCursor<Products> m = p.findByName(categoryname);
		List<String> productname = new ArrayList<String>();
		while(m.hasNext()){

			List<ProductDetails> prodDetails  = m.next().products;
			for(ProductDetails pd : prodDetails){
				//System.out.println("Category Name : " + categoryname);
				//System.out.println("Products ide : " + prdid);
				if(pd.getProductid().equalsIgnoreCase(prdid))
				{ 	
					retailer = pd.getRetailer();
					description = pd.getDescription();
					price = Integer.toString(pd.getPrice());
					imageurl= pd.getImage();
					qrcode= pd.getQrcode();
					name = pd.getName();

					String message = 	description +"/"+ price +"/"+ retailer;
					System.out.println("Message : " + message);

				}
			}
		}
		return ok(product_screen.render(description,price,retailer,imageurl,qrcode,name));
	}

	public Result searchfunc(String categoryname,String searchvalue){

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
		return ok(user_products.render(searchdetails));
	}

}
