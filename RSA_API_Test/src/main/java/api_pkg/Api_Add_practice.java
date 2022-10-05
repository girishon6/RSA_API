package api_pkg;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Api_Add_practice {

	public static void main(String[] args) {
		//Given - add Api Details
		//when  - submit api details - resource and http method
		//then - validate the response
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -45.383494,\r\n" + 
				"    \"lng\": 47.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Girish house\",\r\n" + 
				"  \"phone_number\": \"(+91) 789 893 3501\",\r\n" + 
				"  \"address\": \"06, My layout, cohensive 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"On6 park\",\r\n" + 
				"    \"garden\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}").when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
		

	}

}
