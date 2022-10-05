package api_pkg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class DelBook {

	//DeleteBook
		@Test(dataProvider="DelData")
		public void DeleteBook(String id)
		{	
			RestAssured.baseURI="http://216.10.245.166";
			String str1=given().log().all().header("Content-Type","application/json").body(Add_Body.DeleteBook(id)).
			when().post("Library/DeleteBook.php").
			then().log().all().assertThat().statusCode(200).extract().response().asString();
			
			JsonPath j1=new JsonPath(str1);
			String msg=j1.get("msg");
			System.out.println(msg);
		}
		
		@DataProvider(name="DelData")
		public Object[][] DelData()
		{
			return new Object[][] {{"BACA141"},{"BABA171"},{"BBAA222"}};
		}
	
	
}
