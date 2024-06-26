package abinash.preparation.restAssured;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PathParamExample {
  

	String userName="test1";
	String password="test2";
	

	  @Test
	  public void validate_wholeResponse() {
		  
		given()
		  	.baseUri("http://localhost:8080")
		  	.auth().basic(userName, password)
		  	.pathParam("dept", "HR").
		  when()
		  	.get("/Employee/dept/{dept}").
		  then()
		  	.log().all()
		  	.statusCode(200);
		  	

		 
	  }
}
