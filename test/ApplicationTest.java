import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;

import models.LoginForm;
import models.ProductDetails;
import models.Products;
import models.Users;

import org.jongo.Jongo;
import org.jongo.MongoCursor;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.Form;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;
import static play.test.Helpers.*;
import static org.junit.Assert.*;


/**
 *
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 *
 */
public class ApplicationTest {

	@Test
	public void loginCheck(){

		Helpers.running(Helpers.fakeApplication(), new Runnable() {

			@Override
			public void run() {
				String failedstatus = "failed";
				Users user = Users.findByName("susmithamenda", "retailer123");
				if(user != null) {
					assertNotNull(user.role);
				}else {
					failedstatus = "failed";
					assertEquals(failedstatus,"failed");
				}
			}
		});
	}

	public void signupCheck(){

	}

	@Test
	public void ImageCatalog(){

		Helpers.running(Helpers.fakeApplication(), new Runnable() {

			@Override
			public void run() {

				String id = "IKEA";
				Products prod = new Products();
				MongoCursor<Products> cursor = prod.findall();
				List<ProductDetails> details = new ArrayList<ProductDetails>();
				while (cursor.hasNext()) {
					List<ProductDetails> temp = cursor.next().products;
					for (ProductDetails pd : temp) {
						assertNotNull(pd);
					}
				}
			}
		});
	}

	@Test
	public void adminInbox(){

		Helpers.running(Helpers.fakeApplication(), new Runnable() {

			@Override
			public void run() {

				Users users = new Users();
				MongoCursor<Users> cursor =  users.findByStatus("pending");
				List<Users> userlist = new ArrayList<Users>();
				while(cursor.hasNext()){
					Users user = cursor.next();
					userlist.add(user);
					assertNotNull(user.id);
				}
			}
		});
	}

	@Test
	public void updateUserStatus(){

		Helpers.running(Helpers.fakeApplication(), new Runnable() {

			@Override
			public void run() {
				String userName = "sravyadara";
				//String status,String userName
				Users users = new Users();
				users = Users.findById(userName);
				assertNotNull(users);
			}
		});
	}

	@Test
	public void showRetailerCategories(){

		Helpers.running(Helpers.fakeApplication(), new Runnable() {

			@Override
			public void run() {
				Products p = new Products();
				// Fetching categories list
				List<String> categoryArray = p.getCategories("categoryname");
				assertNotNull(categoryArray);
			}
		});
	}

	/*public void postProductFormData(){
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

			cn = data.productCategory;
			UUID productId = UUID.randomUUID();
			if(p.findCategory(data.productCategory) != null){
				//p.updateCategory(productId, data.productCategory, data.productName, data.productDescription, data.productPrice, qrUrl, imageUrl, session("retailerName"));
			}else {
				List<ProductDetails> productDetailsArray = new ArrayList<ProductDetails>();
				ProductDetails productDetails = new ProductDetails();
				productDetails.setProductid(productId.toString());
				productDetails.setName(data.productName);
				productDetails.setDescription(data.productDescription);
				productDetails.setPrice(data.productPrice);
				productDetails.setQrcode(qrUrl);
				productDetails.setImage(imageUrl);
				productDetails.setRetailer(session("retailerName"));
				productDetailsArray.add(productDetails);
				p.categoryname = data.productCategory;
				p.products = productDetailsArray;
				//p.insert();
			}
		}

	}*/

	@Test
	public void showRetailerProducts(){

		Helpers.running(Helpers.fakeApplication(), new Runnable() {

			@Override
			public void run() {
				String categoryName = "Living Room";
				MongoCursor<Products> cursor = Products.findByName(categoryName);
				List<ProductDetails> filteredProductDetails = new ArrayList<ProductDetails>();
				while(cursor.hasNext()){
					List<ProductDetails> details = cursor.next().products;
					for(ProductDetails d : details) {
						assertNotNull(d.retailer);
					}
				}
			}
		});
	}

	@Test
	public void listofCategories(){

		Helpers.running(Helpers.fakeApplication(), new Runnable() {

			@Override
			public void run() {
				Products p = new Products();
				MongoCursor<Products> mongoCursor = p.findall();
				List<String> categoryList = p.getCategories("categoryname");
				for(String s : categoryList) {
					assertNotNull(s);
				}

			}
		});
	}



	@Test
	public void listofProducts(){

		//user_products/Kitchen
		Helpers.running(Helpers.fakeApplication(), new Runnable() {

			@Override
			public void run() {

				String categoryname = "Kitchen";
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
						assertNotNull(pd);
					}
				}
			}
		});
	}

	@Test
	public void productdetailsfunc(){

		//Kitchen/k-1/false

		String categoryName = "Kitchen";
		String prdid = "k-1";
		String liked="false";

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
		MongoCursor<Products> m = p.findByName(categoryName);
		while(m.hasNext()){

			List<ProductDetails> prodDetails  = m.next().products;

			for(ProductDetails pd : prodDetails){
				assertNotNull(pd);
				if(pd.getProductid().equalsIgnoreCase(prdid))
				{ 	
					String username="sravyadara";
					Users users = new Users();
					users = Users.findById(username);
					List<String> interestedItems = users.interested;
					for(String likeItem:interestedItems){
						assertNotNull(likeItem);
					}

				}
			}
		}

		Products p1 = new Products();
		MongoCursor<Products> m1 = (MongoCursor<Products>) p1.findByName(categoryName);
		while(m1.hasNext()){

			List<ProductDetails> productDetails1  = m1.next().products;
			for(ProductDetails pd : productDetails1){
				assertNotNull(pd);
			}
		}
		if(liked.equalsIgnoreCase("true")){
			String username="sravyadara";
			Users users = new Users();
			users = Users.findById(username);
			assertNotNull(users.interested);
		}
	}

	@Test
	public void searchfunc(){

		//Kitchen/spoon
		String categoryName= "Kitchen";
		String searchvalue = "spoon";

		List<ProductDetails> searchdetails = new ArrayList<ProductDetails>();

		Products p = new Products();
		MongoCursor<Products> m = p.findByName(categoryName);
		while(m.hasNext()){
			List<ProductDetails> prodDetails  = m.next().products;
			for(ProductDetails pd : prodDetails){
				assertNotNull(pd);
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
	}

	@Test
	public void getRecommendations() {
		String loggedUser = "sravyadara";
		Users otherUsers = new Users();
		Users currentUser = new Users();
		currentUser = Users.findById(loggedUser);
		MongoCursor<Users> othersResult = otherUsers.findOtherUsers(loggedUser);
		ArrayList<String> currentUserInterested = currentUser.interested;
		Set<String> recommendationSet = new HashSet<String>();

		assertNotNull(otherUsers);
		while(othersResult.hasNext()) {
			ArrayList<String> othersInterested = othersResult.next().interested;
			ArrayList<String> tempCurrentUserInterested = new ArrayList<String>(currentUserInterested);
			assertNotNull(othersInterested);
			assertNotNull(tempCurrentUserInterested);
			if( (othersInterested.size() > 0) && (findMatchPercentage(tempCurrentUserInterested, othersInterested) > 30) ) {
				//System.out.println("Calling for user : " + othersResult.next().userName);
				recommendationSet.addAll(othersInterested);
			}
		}

		recommendationSet.removeAll(currentUserInterested);
		Iterator iterator = recommendationSet.iterator();
		List<ProductDetails> productDetailsArray = new ArrayList<ProductDetails>();
		assertNotNull(iterator);
		while(iterator.hasNext()) {
			String pid = (String) iterator.next();
			Iterable<Products> rsi = Products.findProduct(pid);
			assertNotNull(rsi);
			while(rsi.iterator().hasNext()) {
				Products pd = rsi.iterator().next();
				productDetailsArray.add(pd.products.get(0));
			}
		}
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
