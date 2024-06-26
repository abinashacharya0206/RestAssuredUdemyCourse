package abinash.preparation.restAssured;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestOne {
	String userName="test1";
	String password="test2";
  @Test
  public void get_request() {
	  
	  given()
	  .baseUri("https://jsonplaceholder.typicode.com")
	  .when()
	  .get("/todos/1")
	  .then()
	  .statusCode(200);
	  
  }
    	
  
  @Test
  public void validate_response() {
	  given()
	  	.baseUri("https://jsonplaceholder.typicode.com").
	  when()
	  	.get("/todos/1").
	  then()
	  	.statusCode(200)
	  	.body("completed", equalTo(false));
  }
  
  @Test
  public void validate_myAPI() {
	  String value=given()
	  	.baseUri("http://localhost:8080")
	  	.queryParam("count", 1)
	  	.auth().basic(userName, password)
	  	.header("User-Application", "Abinash").
	  when()
	  	.get("/Employee/AllEmployees").
	  then()
	  	.statusCode(200)
	  	.body("[0].department", equalTo("HR"))
	  	.extract().path("[0].department");
	  
	  System.out.println(value);
  }
  
  
  @Test
  public void validate_wholeResponse() {
	  Response value=given()
	  	.baseUri("http://localhost:8080")
	  	.queryParam("count", 1)
	  	.auth().basic(userName, password)
	  	.header("User-Application", "Abinash").
	  when()
	  	.get("/Employee/AllEmployees").
	  then()
	  	.statusCode(200)
	  	.body("[0].department", equalTo("HR"))
	  	.extract().response();
	  
	  System.out.println(value.asPrettyString());
  }
}
