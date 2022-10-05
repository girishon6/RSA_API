package api_pkg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class DynamicJson {
	
	
	@Test(dataProvider="BookData")
	public void AddBook(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","application/json").
		body(Add_Body.AddBook(isbn,aisle)).when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath j1= new JsonPath(response);
		String id=j1.get("ID");
		System.out.println(id);
		
	}
	
	@DataProvider(name="BookData")
	public Object[][] sendData()
	{
		return new Object[][] {{"BACA","141"},{"BABA","171"},{"BBAA","222"}};
	}
	
		

}
