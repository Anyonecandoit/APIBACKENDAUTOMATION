package com.test;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AssignmentTest {
	
	@Test
	
	public void assignmentTest() {
		
//	//	ValidatableResponse res = given().get("http://localhost:3000/employees").then().statusCode(200);
//		Response res = given().get("http://localhost:3000/employees");
//
//		//System.out.println(res.getStatusCode());
//	//	System.out.println(res.getTime());
//		//res.prettyPrint();           // this will print response
//	int size =	res.jsonPath().getList("data").size();
//		
//		System.out.println(size);
//		
//		
		
//		String s = "{\"id\": \"12328\",\r\n"
//				+ "\r\n"
//				+ "\"first_name\": \"John\",\r\n"
//				+ "\r\n"
//				+ "\"last_name\": \"Doe\",\r\n"
//				+ "\r\n"
//				+ "\"email\": \"john.doe@example.com\"}";
//	Response re = 	 given().header("Content-Type", "application/json").body(s).log().all().post("http://localhost:3000/employees");
//	//re.prettyPrint();
		
		
//		JSONObject address = new JSONObject();
//		address.put("state", "telangana");
//		obj.put("addresses", address);
	
	JSONObject user = new JSONObject();
	user.put("id", 30);
	user.put("name", "kranthi");
	user.put("email", "john.doe@example.com");
	user.put("age", 30);
	
	JSONObject address = new JSONObject();
	address.put("street", "123 Main St");
	address.put("city", "Anytown");
	address.put("state", "NY");
	address.put("zip", "12345");
	address.put("country", "USA");
	
	user.put("addresses", address);
	
	
	
	JSONArray contacts = new JSONArray();
	

JSONObject contact1 = new JSONObject();
contact1.put("type", "phone");
contact1.put("number", "555-1234");
JSONObject contact2 = new JSONObject();
contact2.put("type", "email");
contact2.put("address", "john.doe@gmail.com");
	

contacts.put(contact1);
contacts.put(contact2);

user.put("contacts", contacts);











// Creating products array
JSONArray products = new JSONArray();

// Creating first product object
JSONObject product1 = new JSONObject();
product1.put("id", 1);
product1.put("name", "Product A");
product1.put("price", 19.99);
product1.put("quantity", 2);

JSONObject attributes1 = new JSONObject();
attributes1.put("color", "blue");
attributes1.put("size", "medium");
product1.put("attributes", attributes1);

// Creating second product object
JSONObject product2 = new JSONObject();
product2.put("id", 2);
product2.put("name", "Product B");
product2.put("price", 29.99);
product2.put("quantity", 1);

JSONObject attributes2 = new JSONObject();
attributes2.put("color", "red");
attributes2.put("size", "large");
product2.put("attributes", attributes2);

// Adding products to the array
products.put(product1);
products.put(product2);

// Creating payment object
JSONObject payment = new JSONObject();
payment.put("method", "credit_card");

JSONObject cardDetails = new JSONObject();
cardDetails.put("card_number", "1234567890123456");
cardDetails.put("expiry_date", "12/25");
cardDetails.put("cvv", "123");

payment.put("card_details", cardDetails);

// Creating shipping object
JSONObject shipping = new JSONObject();
shipping.put("method", "standard");

JSONObject shippingAddress = new JSONObject();
shippingAddress.put("street", "456 Elm St");
shippingAddress.put("city", "Othertown");
shippingAddress.put("state", "CA");
shippingAddress.put("zip", "54321");
shippingAddress.put("country", "USA");

shipping.put("address", shippingAddress);
shipping.put("instructions", "Leave package by the door if not home.");

// Creating additional_info object
JSONObject additionalInfo = new JSONObject();
additionalInfo.put("promo_code", "SUMMER25");
additionalInfo.put("gift_message", "Happy Birthday!");
additionalInfo.put("notes", "Customer prefers eco-friendly packaging.");

// Creating main JSON object
JSONObject obj = new JSONObject();
obj.put("user", user);
obj.put("products", products);
obj.put("payment", payment);
obj.put("shipping", shipping);
obj.put("additional_info", additionalInfo);

System.out.println(obj.toString());
	Response re = 	 given().header("Content-Type", "application/json").body(obj).log().all().post("http://localhost:3000/employees");
     re.prettyPrint();
	}

}
