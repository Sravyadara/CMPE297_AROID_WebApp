package models;

import java.util.ArrayList;

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
	public String firstName;
	public String lastName;
	public String role;
	public String emailId;
	public long contactNum;
	public String userName;
	public String password;
	public String retailer;
	public String status;
	public ArrayList<String> interested;
	
	
	public Users(){
		
	}
	
	 public Users(String firstName,String lastName,String role,String emailId,long contactNum,String userName,String password,String retailer,String status){
			this.firstName = firstName;
			this.lastName = lastName;
			this.role = role;
			this.emailId = emailId;
			this.contactNum = contactNum;
			this.userName = userName;
			this.password = password;
			this.retailer = retailer;
			this.status = status;
			this.interested = new ArrayList<String>();
		}
	 public ArrayList getInterested() {
			return interested;
		}

		public void setInterested(ArrayList<String> type) {
			this.interested = interested;
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
	
	public static Users findByName(String userName, String userPwd){
		System.out.println("Calling query");
		return users().findOne("{userName: #, password:#}", userName, userPwd).as(Users.class);
//		if(u != null) {
//			return u.role;
//		}else {
//			return "Invalid";
//		}
		
		
	}
	
	public void update(){
		users().update(id).with(this);
	}
}
