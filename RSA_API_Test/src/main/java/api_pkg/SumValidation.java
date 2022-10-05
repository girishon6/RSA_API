package api_pkg;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumOfCourses()
	{
		String Response=Add_Body.DummyResponse();
		JsonPath j1= new JsonPath(Response);
		
		/*Total Course Size*/
		int CourseSize = j1.getInt("courses.size()");
		//System.out.println(CourseSize);
		
		/*Verify if Sum of all Course prices matches with Purchase Amount*/
		int total_crse_price=0;
		for(int i=0; i<=CourseSize-1; i++)
		{
			int price1=j1.get("courses["+i+"].price");
			int copies1=j1.get("courses["+i+"].copies");
			int prod=price1*copies1;
			total_crse_price+=prod;
							
		}
		System.out.println("Total course price:"+total_crse_price);
		int PurchAmt=j1.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(total_crse_price,PurchAmt);
		
	}
	}


