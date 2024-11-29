package Files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class Jira_BUG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RestAssured.baseURI= "https://bits1115.atlassian.net";
		
	String Createissueresponse=	given().header("Content-Type", "application/json").header("Authorization", "Basic Yml0czExMTVAZ21haWwuY29tOkFUQVRUM3hGZkdGMG9xN0ZpeVpxUnVZOFJGcTh2QW5WUi12WXU0MldHNnRtWkdHVVIyNFJFai0wWUFoTHhxX1I2emh1UUpsWGtWVkFPRU52dmNUS2NVNDBBbElzR1lNb0x1MlBGN2RwRC0xODJZUDA5bDNLdzJRWnhZYXlsX0k0ZUVFaDFrRktleFRRZUxsOGgtb0VlVklQbWExd2dIX2c5QUpLelNENXlYUl9NcFFsTDJ5bmUtRT0xRDRCMjk5Rg==")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Bug333-Restful API with attchment \",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}")
		.when().post("rest/api/3/issue")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		
		
		JsonPath js = new JsonPath(Createissueresponse);
		String issueid = js.getString("id");
		
		System.out.println(issueid);
		
		
		// Attachment 
		
		given().pathParam("key", issueid)
		.header("X-Atlassian-Token", "no-check")
		.header("Authorization","Basic Yml0czExMTVAZ21haWwuY29tOkFUQVRUM3hGZkdGMG9xN0ZpeVpxUnVZOFJGcTh2QW5WUi12WXU0MldHNnRtWkdHVVIyNFJFai0wWUFoTHhxX1I2emh1UUpsWGtWVkFPRU52dmNUS2NVNDBBbElzR1lNb0x1MlBGN2RwRC0xODJZUDA5bDNLdzJRWnhZYXlsX0k0ZUVFaDFrRktleFRRZUxsOGgtb0VlVklQbWExd2dIX2c5QUpLelNENXlYUl9NcFFsTDJ5bmUtRT0xRDRCMjk5Rg==")
		.multiPart("file", new File("C:\\Users\\MaheshKumar\\Desktop\\screnshot"))
		.log().all()
		.when().post("rest/api/3/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200);
		
	}

}
