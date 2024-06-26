package abinash.preparation.restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class TestThree {
 
	String userName="test1";
	String password="test2";
	
	
	  @Test
	  public void validate_myAPI() {
		  given()
		  	.baseUri("http://localhost:8080")
		  	//.queryParam("count", 1)
		  	//.auth().basic(userName, password)
		  	.header("User-Application", "Abinash").
		  when()
		  	.get("/Employee/AllEmployees").
		  then()
		  //every log will come before validation
		  .log().ifValidationFails()
		  .statusCode(200);
		  
		  //.log().ifError();
		  //.log().all();
		  //.log.body();
		  //.log.headers();
		  //.log.cookies();
		  //.log.status();
		  //.log.everything();
		  
	  }
}
