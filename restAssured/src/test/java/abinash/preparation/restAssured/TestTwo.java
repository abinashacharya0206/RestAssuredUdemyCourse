package abinash.preparation.restAssured;

import static io.restassured.RestAssured.given;


import java.io.File;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestTwo {
	
	String userName="test1";
	String password="test2";
	

	  @Test
	  public void validate_wholeResponse() {
		  
		  File file=new File("resources/post_content.json");
		  
		  Response response=given()
		  	.baseUri("http://localhost:8080")
		  	.auth().basic(userName, password)
		  	.contentType(ContentType.JSON)
		  	.body(file).
		  when()
		  	.post("/Employee/add").
		  then()
		  	.statusCode(201)
		  	.extract().response();
		  
		  System.out.println(response);
		 
	  }
	
	
	  @Test
	  public void validate_response() {
		  
		 
			JSONObject jsonbody=new JSONObject();
			jsonbody.put("name", "Danavira");
			jsonbody.put("age", 30);
			jsonbody.put("department", "Druggist");
			jsonbody.put("salary", 30000);
			
		  Response response=given()
		  	.baseUri("http://localhost:8080")
		  	.auth().basic(userName, password)
		  	.contentType(ContentType.JSON)
		  	.body(jsonbody.toString()).
		  when()
		  	.post("/Employee/add").
		  then()
		  	.statusCode(201)
		  	.extract().response();
		  
		  System.out.println(response);
		 
	  }
	  
	  
	  
}
