package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.jongo.Aggregate;
import org.jongo.Aggregate.ResultsIterator;
import org.jongo.Distinct;
import org.jongo.Find;
import org.jongo.FindOne;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import uk.co.panaxiom.playjongo.PlayJongo;
public class Products {

	public static MongoCollection products() {
		return PlayJongo.getCollection("products");
	}

	@MongoId
	public ObjectId id;
	public String categoryname;
	public List<ProductDetails> products;
	
	public Products(){}
	
	public Products( String categoryName, List<ProductDetails> pd) {
		this.categoryname = categoryName;
		this.products = pd;
	}
	
	public long getCount(){
		return products().count();
	}

	public List<String> getCategories(String categoryId) {
		return products().distinct(categoryId).as(String.class);
	}
	
	public void insert() {
		products().save(this);
	}
	
	public void updateCategory(String productId, String categoryName, String productName, String productDescription, String productType, int productPrice, String productQRCode, String productImage, String retailerName) {
		
		products().update("{categoryname: #}", categoryName)
			.with("{$push: {products: {productid:#, name: #, Description: #, price: #, type: #, qrcode: #, image:#, retailer: #}}}", productId, productName, productDescription, productPrice, productType, productQRCode, productImage, retailerName);
	}
	
	public void remove() {
		products().remove(this.id);
	}
	
//	public ResultsIterator<Products> getRetailerProducts() {
//		return products().aggregate("{$match: {'categoryname':#}}","Living").and("{$match: {'products.retailer': #}}", "ikea").as(Products.class);
//		//return products().aggregate("[{$unwind: '$products'}, {$match: {'products.retailer': {$eq: #}, 'categoryid' : {$eq: #}}}, {$group: {_id: '$_id', products: {$push: '$products'}}}]", retailerName, categoryId).as(Products.class);
//	}
	
	public MongoCursor<Products> findall(){

		return products().find().as(Products.class);
	}
	
	public MongoCursor<Products> getCategoryProducts(String categoryName){
		return products().find("{categoryname: #}", categoryName).as(Products.class);
	}
	
	
	public static Products findById(ObjectId id2) {
		return products().findOne("{_id: #}",id2).as(Products.class);
		//return Images().findOne({"name":"sravyadara"},{"name.$":1}).as(ImagesClass.class);
		//find({"responsaveis" : "daniela.morais@sofist.com.br"},{"responsaveis.$":1})
	}
	
	public static MongoCursor<Products> findByName(String catname) {
	       return products().find("{categoryname: #}",catname).as(Products.class);
	        //return Images().findOne({"name":"sravyadara"},{"name.$":1}).as(ImagesClass.class);
	        
	}
	
	public static Products findCategory(String categoryName) {
	       return products().findOne("{categoryname: #}",categoryName).as(Products.class);
	        //return Images().findOne({"name":"sravyadara"},{"name.$":1}).as(ImagesClass.class);
	        
	}
	
//	public static Products findProductByName(String name){
//	       return products().findOne("{products.retailer: #}", name).as(Products.class);
// 	
//	  }
}
