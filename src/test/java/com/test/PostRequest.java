package com.test;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
public class PostRequest {

	
	@Test(enabled = false)
	public void ptest() {
		
		String k = "{\r\n"
				+ " \"id\": \"9\",\r\n"
				+ "\"first_name\": \"Jaohn\",\r\n"
				+ "	\"last_name\": \"Daoe\",\r\n"
				+ "	 \"email\": \"joaaaahn.doe@example.com\"\r\n"
				+ "}";
	Response res = 	given()
			
			
			
			.header("Content-Typ","application/json")
			//.header(ContentType.JSON)
			
			.body(k).log().all().post("http://localhost:3000/employees");
		
	System.out.println(res);	
	res.prettyPrint();
	
	}
	
	// using external file 
	// we cant get the request from the file and print on the consoole 
	// if in file ,, only static data .
	@Test(enabled = false)
	
	public void test1 () {
	Response r = 	given()	.header("Content-Typ","application/json").body(new File("F:\\001-apitesting\\test.json")).post("http://localhost:3000/employees");
		r.prettyPrint();
	}
	
	
	
	
	
	
	// read request body from an external fle and  convert to string 
	// logs request in console 
	// change few parameters 
	
	//not suitable for request  having lot of dynamic parameter
	
	
@Test(enabled = false)
	
	public void test2 () throws IOException {
	
	
	byte[] bytes = Files.readAllBytes(Paths.get("F:\\001-apitesting\\test.json"));
	
	String reqbody = new String(bytes);
	Response r = 	given()	.header("Content-Typ","application/json").body(reqbody).post("http://localhost:3000/employees");
		r.prettyPrint();
	}
	



//..............................................//



// using faker 

@Test(enabled = false)

public void test3 () throws IOException {


byte[] bytes = Files.readAllBytes(Paths.get("F:\\001-apitesting\\test.json"));

String reqbody1 = new String(bytes);

String reqbody = reqbody1.replace("14", String.valueOf(new Faker().number().numberBetween(100, 1000)));
Response r = 	given()	.header("Content-Type","application/json").body(reqbody).post("http://localhost:3000/employees");
	r.prettyPrint();
}

//using map and list from java

// {} -> map interfaces

// [] -> list 

//It seems like you want to serialize the Map<String, Object> object into JSON format, but there is no JSON serializer library available in your classpath. You can use any of the mentioned libraries like Jackson (Databind), Gson, Johnzon, or Yasson to serialize the map into JSON format.

 //Here's how you can do it using Gson:

//First, you need to add Gson library to your project dependencies. You can download Gson from here or add it as a Maven or Gradle dependency.
//Then, you can use Gson to serialize the map into JSON format.


 // serialisers -> converts you language objects to byte streams -> json file 


// without addin you will get above erros with adding it will resolve 
// after adding jackson data bind it got converted to json


//cons : verbose and not suitable for big json file 

// generic type needs to be mentioned 

@Test(enabled = false)

public void test4 () throws IOException {

	
	//Map<String , Object>  obj = new HashMap<>();
	Map<String , Object>  obj = new LinkedHashMap<>();
	
	obj.put("id", new Faker().number().numberBetween(80, 900));
    obj.put("first_name", "John");
    obj.put("last_name", "Doe");
    obj.put("email", "john.doe@example.com");
	List<String> 	Listofjobs = new ArrayList<>();
	Listofjobs.add("tester");
	Listofjobs.add("trainer");	
obj.put("jobs", Listofjobs);  


Map<String, Object> food = new HashMap<>();

food.put("breakfast", "idly");
food.put("lunch", "rice");

List<String> dinnerFood = new ArrayList<>();
dinnerFood.add("dosa");
dinnerFood.add("biryani");

food.put("dinner", dinnerFood);

obj.put("favfoods", food) ;  


	
    Response res = given().header("Content-Type","application/json").body(obj).post("http://localhost:3000/employees");
    res.prettyPrint();    
}




//..........................................................................................................//


// using external json library
// having some collections that can solve the problems we had using map and list 


// {} ->> json object 

//[] ->> JSON ARRAY


@Test

public void test5() {
	
	JSONObject obj = new JSONObject();
	obj.put("id", new Faker().number().numberBetween(80, 900));
    obj.put("first_name", "John");
    obj.put("last_name", "Doe");
    obj.put("email", "john.doe@example.com");
    
    JSONArray listofjobs = new JSONArray();
    
    listofjobs.put("tester");
    listofjobs.put("trainer");
    
	obj.put("jobs", listofjobs);
	

    
    JSONObject favFoods = new JSONObject();
    favFoods.put("breakfast", "idly");
    favFoods.put("lunch", "rice");
    obj.put("favfoods", favFoods);
    
    
    
	JSONArray dinnerFoods = new JSONArray();
    dinnerFoods.put("chapathi");
    dinnerFoods.put("rice");
    favFoods.put("dinner", dinnerFoods);
    
    Response res = given().header("Content-Type","application/json").body(obj.toString()).post("http://localhost:3000/employees");
    res.prettyPrint(); 
    
    Response res1 = given().header("Content-Type","application/json").body(obj.toMap()).post("http://localhost:3000/employees");
    res1.prettyPrint();   
     
  
}



}
