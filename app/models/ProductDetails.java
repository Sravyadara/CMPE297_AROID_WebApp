package models;

import java.util.List;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.MongoId;

public class ProductDetails {
	
	public String name;
	public String productid;
	public String Description;
	public int price;
	public String qrcode;
	public String wt3;
	public String image;
	public String retailer;
	
	public ProductDetails() {
		
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getWt3() {
		return wt3;
	}

	public void setWt3(String wt3) {
		this.wt3 = wt3;
	}

	public String getRetailer() {
		return retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}
	
	
	
	
	
	
	
}
