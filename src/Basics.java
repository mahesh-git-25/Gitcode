import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.payload;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//given--- all input details 
		//when-- https method and resource
		//then--- validate the response
		
		
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response =given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
				
	    System.out.println(response);
	    
	    JsonPath js = new JsonPath(response);
	    String placeid = js.getString("place_id");
	    
	    System.out.println(placeid);

	    
	   //update place
	    
	    given().queryParam("key","qaclick123").header("Content-Type","application/json")
	    .body("{\r\n"
	    		+ "\"place_id\":\""+placeid+"\",\r\n"
	    		+ "\"address\":\"70 Summer walk, USA\",\r\n"
	    		+ "\"key\":\"qaclick123\"\r\n"
	    		+ "}")
	    .when().put("maps/api/place/update/json")
	    .then().assertThat().statusCode(200);
	    
	    
	    
	    
	}

}
