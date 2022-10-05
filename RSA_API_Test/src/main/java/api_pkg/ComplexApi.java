package api_pkg;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ComplexApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String Response=Add_Body.DummyResponse();
		JsonPath j1= new JsonPath(Response);
		
		/*Total Course Size*/
		int CourseSize = j1.getInt("courses.size()");
		System.out.println(CourseSize);
		
		/*print purchase Amount*/
		int pur_amt=j1.get("dashboard.purchaseAmount");
		System.out.println(pur_amt);
		
		/*print first course title*/
		String Firt_crse=j1.get("courses[0].title");
		System.out.println("First Course: "+Firt_crse);
		
		/*Print All course titles and their respective Prices*/
		
		System.out.println("*****All titles and prices*******");
		for(int i=0; i<=CourseSize-1; i++)
		{
			
			System.out.println(j1.get("courses["+i+"].title")+" "+ j1.getByte("courses["+i+"].price"));
		}
		
		/*Print no of copies sold by RPA Course*/
		for(int i=0; i<=CourseSize-1; i++)
		{
			if(j1.get("courses["+i+"].title").equals("RPA"))
			{
				System.out.println("Total copies sold by RPA Course: "+j1.getInt("courses["+i+"].copies"));
				break;
			}
			
		}
		
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
