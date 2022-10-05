package api_pkg;

public class Add_Body {

	public static String Add_c() 
	{
		return("{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -35.383494,\r\n" + 
				"    \"lng\": 31.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"On6 house\",\r\n" + 
				"  \"phone_number\": \"(+91) 789 893 3937\",\r\n" + 
				"  \"address\": \"06, front layout, cohens 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"Central park\",\r\n" + 
				"    \"garage\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://rahulshettyacademy.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}");

	}
	public static String DummyResponse()
	{
		return ("{\r\n" + 
				"\"dashboard\": {\r\n" + 
				"\"purchaseAmount\": 1360,\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"},\r\n" + 
				"\"courses\": [\r\n" + 
				"{\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\"price\": 50,\r\n" + 
				"\"copies\": 6\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\"price\": 40,\r\n" + 
				"\"copies\": 4\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\"price\": 45,\r\n" + 
				"\"copies\": 10\r\n" + 
				"},\r\n" + 
				"  {\r\n" + 
				"\"title\": \"C#\",\r\n" + 
				"\"price\": 45,\r\n" + 
				"\"copies\": 10\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}");
	}
	
	public static String AddBook(String isbn,String aisle)
	{
		String str="{\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"Rock\"\r\n" + 
				"}";
		
		return(str);
	}
	public static String DeleteBook(String id)
	{
		String str="{\r\n" + 
					"\"ID\" : \""+id+"\"\r\n" + 
					"}";
		return str;
	}

}
