package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3Handler {

	public AmazonS3 s3;
	
	public S3Handler() {
		System.out.println("Inside S# Handler class");
		AWSCredentials credentials = null;
		
		
        try {
            credentials = new ProfileCredentialsProvider("default").getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (~/.aws/credentials), and is in valid format.",
                    e);
        }
        
        s3 = new AmazonS3Client(credentials);
        
        
	}
	
	public void getBucketList(){	
		System.out.println("Inside bucket method");
		List<Bucket> bucketList = s3.listBuckets();
		System.out.println("Prinitng buckts object");
		for(Bucket bucket: bucketList){
			
			System.out.println("Bucket Name : " + bucket.getName());
		}
			
	}
	
	public String uploadImageFile(File file, String key) {
		String s = "";
		try{
		s3.putObject(new PutObjectRequest("ramyakysamplebucket",key, file ).withCannedAcl(CannedAccessControlList.PublicRead));
		s = "https://ramyakysamplebucket.s3.amazonaws.com/" + key;
		}catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
		
		return s;
		
	}
	
	

}
