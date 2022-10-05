package api_pkg;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Assert;


public class Add_api {

	public static void main(String[] args) throws IOException {
	
	// validate if Add Place API is working as expected
		// Given - all the input details
		//When - Submit the specific API - resource and Http method
        //then - Validate the response

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\gkumbar\\OneDrive - UHG\\Documents\\RSA_API_Files\\Add C.json")))).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("Server", "Apache/2.4.41 (Ubuntu)").extract().asString();
		
		System.out.println("response :" + response);
		
		System.out.println("***********************");
		
		JsonPath js = new JsonPath(response);// for parsing response
		String Place_id=js.getString("place_id");
		System.out.println(Place_id);
		
		//Update place
		
		String New_address="Summer Walk, Africa";
		System.out.println("*****Update*****");
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+Place_id+"\",\r\n" + 
				"\"address\":\""+New_address+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").
		when().put("maps/api/place/update/json").then().log().all().assertThat()
		.statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//Get Place
		
		/* My way
		 System.out.println("*****Get*****");
		given().log().all().queryParams("key","qaclick123","place_id",Place_id)
		.when().get("maps/api/place/get/json").then().log().all().assertThat()
		.statusCode(200).body("address", equalTo("Summer Walk, Africa"));
		*/
		
		/*RSA way to fetch get response*/
		/*Get method*/
		
		String getResponse = given().log().all().queryParams("key","qaclick123","place_id",Place_id)
		.when().get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract()
		.response().asString();
		System.out.println("*****Get Method******");
		JsonPath js1= new JsonPath(getResponse);
		String addrStr=js1.getString("address");
		System.out.println(addrStr);
		
		Assert.assertEquals(addrStr, New_address);

}}
