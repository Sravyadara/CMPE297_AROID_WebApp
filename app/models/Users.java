package models;

import org.bson.types.ObjectId;
import org.jongo.FindOne;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.jongo.Update;
import org.jongo.marshall.jackson.oid.MongoId;

import com.mongodb.WriteResult;

import uk.co.panaxiom.playjongo.PlayJongo;

public class Users {

	
	public static MongoCollection users(){
		return PlayJongo.getCollection("users");
	}
	
	 @MongoId  
	public  ObjectId id;
	public String customerId;
	public String firstName;
	public String lastName;
	public String role;
	public String emailId;
	public long contactNum;
	public String userName;
	public String password;
	public String retailer;
	public String status;
	
	
	public Users(){
		
	}
	
	public void insert() {
	   users().save(this);
	}

	public void remove() {
	   users().remove(this.id);
	}
	
	public static MongoCursor<Users> findByStatus(String status){
		return users().find("{status: #}", status).as(Users.class);	
	}
	
	public static Users findById(String id){
		System.out.println(id);
		 return users().findOne("{userName: #}", id).as(Users.class);
		//return users().findOne(id).as(Users.class);
	}
	
	public static Users findByName(String firstName){
		return users().findOne("{firstName: #}", firstName).as(Users.class);	
	}
	
	public static String findByName(String userName, String userPwd){
		Users u = users().findOne("{userName: #, password:#}", userName, userPwd).as(Users.class);
		if(u != null) {
			return u.role;
		}else {
			return "Invalid";
		}
		
		
	}
	
	public void update(){
		users().update(id).with(this);
	}
}
