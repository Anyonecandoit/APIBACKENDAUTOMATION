
package com.test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.response.Response;


@Listeners(com.listeners.TestListener.class)
public class GetRequest extends BaseTest {

 
    	 @Test
    	    public void getTest() {
    	        Response res = given().get("https://reqres.in/api/users/2");
    	        System.out.println(res);
    	        
    	        // Extracting and printing the details of the user
    	        int id = res.jsonPath().getInt("data.id");
    	        String email = res.jsonPath().getString("data.email");
    	        String firstName = res.jsonPath().getString("data.first_name");
    	        String lastName = res.jsonPath().getString("data.last_name");
    	        String avatar = res.jsonPath().getString("data.avatar");
    	        
    	        System.out.println("User ID: " + id);
    	        System.out.println("Email: " + email);
    	        System.out.println("First Name: " + firstName);
    	        System.out.println("Last Name: " + lastName);
    	        System.out.println("Avatar URL: " + avatar);
    	        
    	       // Extracting and printing the support details
    	        String supportUrl = res.jsonPath().getString("support.url");
    	        String supportText = res.jsonPath().getString("support.text");
    	        
    	        System.out.println("Support URL: " + supportUrl);
    	        System.out.println("Support Text: " + supportText);
    	        
    	        
    	        
//   	        
//   	        String requestbody = "{\r\n"    	        		+ "    \"name\": \"morpheus\",\r\n"
//   	        		+ "    \"job\": \"leader\"\r\n"
//   	        		+ "}";
//    	        
//    	        
//    	       Response res1 =  given().header("Content-Type", "application/json").body(requestbody).log().all().post("https://reqres.in/api/users");
//    	        System.out.println(res1);
    	        
    	 }}
