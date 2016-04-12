import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
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
    public void simpleCheck() {
        int a = 1 + 1;
        assertEquals(2, a);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertEquals("text/html", contentType(html));
        assertTrue(contentAsString(html).contains("Your new application is ready."));
    }
    
    public void loginCheck(){

		//String usernmae, String password

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
	    		System.out.println("printing images");
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
	    		assertEquals(details.size(),6);
	        }
	    });
		

		/*List<ProductDetails> verifydetails = new ArrayList<ProductDetails>();
		for(int i = 0; i < 5; i++){
			verifydetails.add(new ProductsDetails("Conference Chair"),"2"
					,"Designed to accommodate one sitting , providing support for the back."
					,200, " https://s3-us-west-1.amazonaws.com/project295images/qr_conferencechair.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/conferencechairdemo.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/conferencechairdemo.jpg","ikea");
			verifydetails.add(new ProductsDetails("Lorelai Sofa"),"5"
					,"Different colors, textures and patterns have the ability to transform items like the Lorelai sofa."
					,200, "https://s3-us-west-1.amazonaws.com/project295images/qr_conferencechair.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/portfolio_pic4.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/portfolio_pic4.jpg","ikea");
			verifydetails.add(new ProductsDetails("Red Chair"),"6"
					,"Fresh twist on style. Breathe new life into your space with the delightfully vibrant Honnally accent chair"
					,800, "https://s3-us-west-1.amazonaws.com/project295images/qr_woodencube.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/red_chair.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/red_chair.jpg","ikea");
			verifydetails.add(new ProductsDetails("Conference Chair"),"2"
					,"Designed to accommodate one sitting , providing support for the back."
					,200, "https://s3-us-west-1.amazonaws.com/project295images/qr_conferencechair.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/conferencechairdemo.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/conferencechairdemo.jpg","ikea");
			verifydetails.add(new ProductsDetails("Lorelai Sofa"),"5"
					,"Different colors, textures and patterns have the ability to transform items like the Lorelai sofa."
					,200, "https://s3-us-west-1.amazonaws.com/project295images/qr_conferencechair.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/portfolio_pic4.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/portfolio_pic4.jpg","ikea");
			verifydetails.add(new ProductsDetails("Red Chair"),"6"
					,"Fresh twist on style. Breathe new life into your space with the delightfully vibrant Honnally accent chair"
					,800, "https://s3-us-west-1.amazonaws.com/project295images/qr_woodencube.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/red_chair.jpg"
					,"https://s3-us-west-1.amazonaws.com/project295images/red_chair.jpg","ikea");

		}*/
		

	}

	@Test
	public void adminInbox(){
		
		Helpers.running(Helpers.fakeApplication(), new Runnable() {

	        @Override
	        public void run() {

	        	Users users = new Users();
	    		MongoCursor<Users> cursor = users.findByStatus("pending");
	    		List<Users> userlist = new ArrayList<Users>();
	    		while(cursor.hasNext()){
	    			userlist.add(cursor.next());
	    		}
	    		assertEquals(userlist.size(),5);
	        }
	    });
	}

	/*public void updateUserStatus(){

		String status;
		String userName;
		//String status,String userName
		Users users = new Users();
		users = Users.findById(userName);
		System.out.println(users.lastName);
		users.status = status;
		users.update();
	}*/

	@Test
	public void showRetailerCategories(){

		Helpers.running(Helpers.fakeApplication(), new Runnable() {

	        @Override
	        public void run() {
	        	Products p = new Products();
	    		// Fetching categories list
	    		List<String> categoryArray = p.getCategories("categoryname");
	    		assertEquals(categoryArray.size(),2);
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

	public void showRetailerProducts(){

		Helpers.running(Helpers.fakeApplication(), new Runnable() {

	        @Override
	        public void run() {
	        	String categoryname = "Living Room";
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
	    		assertEquals(filteredProductDetails.size(),0);
	        }
	    });
	}
	/*

	public void listofCategories(){

		Products p = new Products();
		System.out.println("Printng number of rows in products collections : " + p.getCount() + " and " + p.findall().count() );
		MongoCursor<Products> mongoCursor = p.findall();
		List<String> categoryArray = p.getCategories("categoryname");
		System.out.println("Printing Distinct values : " + p.getCategories("categoryname").size());
		for(String s : p.getCategories("categoryname")) {
			System.out.println("Category : "+ s);
		}

	}

	
	
	
	public void listofProducts(){
		
		Helpers.running(Helpers.fakeApplication(), new Runnable() {

	        @Override
	        public void run() {
	        	
	        	String categoryname;
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
	    		assertEquals(proddetails.size(),0);
	        }
	    });
		
		


	}/*

	public void productdetailsfunc(){

		String categoryname,;
		String prdid;

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
	}

	public void searchfunc(){

		String categoryname;
		String searchvalue;

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
	}*/



}
