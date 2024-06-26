package abinash.preparation.restAssured;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class QueryParamtest {
	 
		String userName="test1";
		String password="test2";
		
		
		  @Test
		  public void validate_myAPI() {
			  
			  File file=new File("resources/post_content.json");
			  
			  HashMap<String, Object> queryParams=new HashMap<String, Object>();
			  queryParams.put("count", 1);
			  queryParams.put("dept", "HR");
			  
			  given()
			  	.baseUri("http://localhost:8080")
			  	.queryParams(queryParams)
			  	//.auth().basic(userName, password)
			  	.header("User-Application", "Abinash")
			  	.contentType(ContentType.JSON)
			  	.body(file).
			  when()
			  	.post("/Employee/testadd").
			  then()
			  //every log will come before validation
			  .log().ifValidationFails()
			  .statusCode(201);

			  
		  }
}
