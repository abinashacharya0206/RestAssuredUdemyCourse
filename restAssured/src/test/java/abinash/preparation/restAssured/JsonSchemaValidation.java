package abinash.preparation.restAssured;

import static io.restassured.RestAssured.given;

import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.testng.annotations.Test;

public class JsonSchemaValidation {

	  @Test
	  public void validate_myAPI() {
		  
		   File file = new File("resources/JsonSchema.json");
		  given()
		  	.baseUri("http://localhost:8080")
		  	.queryParam("count", 1)
		  	//.auth().basic(userName, password)
		  	.header("User-Application", "Abinash").
		  when()
		  	.get("/Employee/AllEmployees").
		  then()
		  //every log will come before validation
		  .log().ifValidationFails()
		  .statusCode(200)
		  .body(matchesJsonSchema(file));
}
}