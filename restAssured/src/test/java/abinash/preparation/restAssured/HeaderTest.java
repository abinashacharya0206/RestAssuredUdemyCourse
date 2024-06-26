package abinash.preparation.restAssured;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HeaderTest {
	
	
	 @Test
	  public void validate_myAPI() {
		 
		 
		 HashMap<String, Object> headers=new HashMap<>();
		 headers.put("User-Application", "Abinash");
		 
		  given()
		  	.baseUri("http://localhost:8080")
		  	.queryParam("count", 1)
		  	//.auth().basic(userName, password)
		  	.headers(headers).
		  	//.cookie("test", "Cook"). (To send cookies)
		  	
		  when()
		  	.get("/Employee/AllEmployees").
		  then()
		  //every log will come before validation
		  .log().ifValidationFails()
		  .statusCode(200);
}
}