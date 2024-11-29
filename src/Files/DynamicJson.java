package Files;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;





import io.restassured.RestAssured;



import io.restassured.path.json.JsonPath;



import io.restassured.response.Response;






public class DynamicJson {

	
	@Test
	public void addbook()
	{
		
		RestAssured.baseURI= "http://216.10.245.166";
		
	String response=	given().header("Content-Type", "appliactio/json").body(payload.addbook())
		.when().post("Library/Addbook.php")
		.then().statusCode(200).extract().response().asString();
		
		
		System.out.println(response);
	}
}

