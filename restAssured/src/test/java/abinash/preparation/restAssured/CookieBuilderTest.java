package abinash.preparation.restAssured;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Headers;

public class CookieBuilderTest {
	 
	 @Test
	  public void validate_myAPICookie() {
		 
		 Cookie cookie=new Cookie.Builder("testCookie","test").build();
	 
	 HashMap<String, Object> headers=new HashMap<>();
	 headers.put("User-Application", "Abinash");
	 
	  given()
	  	.baseUri("http://localhost:8080")
	  	.queryParam("count", 1)
	  	//.auth().basic(userName, password)
	  	.headers(headers).
	  	//.cookie(cookie). (To send cookies)
	  	
	  when()
	  	.get("/Employee/AllEmployees").
	  then()
	  //every log will come before validation
	  .log().ifValidationFails()
	  .statusCode(200)
	  .header("Connection", "keep-alive");
	  
}
	 
	 @Test
	  public void validate_myAPIgetAllHeaders() {
		 
		 Cookie cookie=new Cookie.Builder("testCookie","test").build();
	 
	 HashMap<String, Object> header=new HashMap<>();
	 header.put("User-Application", "Abinash");
	 
	 Headers headers= given()
	  	.baseUri("http://localhost:8080")
	  	.queryParam("count", 1)
	  	//.auth().basic(userName, password)
	  	.headers(header).
	  	//.cookie(cookie). (To send cookies)
	  	
	  when()
	  	.get("/Employee/AllEmployees").
	  then()
	  //every log will come before validation
	  .log().ifValidationFails()
	  .statusCode(200)
	  .extract().headers();
	 
	 System.out.println(headers.getValue("Connection"));
	  
}
	 
	 @Test
	  public void validate_myAPIgetAllCookies() {
		 
		 Cookie cookie=new Cookie.Builder("testCookie","test").build();
	 
	 HashMap<String, Object> header=new HashMap<>();
	 header.put("User-Application", "Abinash");
	 
	 Map<String, String> cook= given()
	  	.baseUri("http://localhost:8080")
	  	.queryParam("count", 1)
	  	//.auth().basic(userName, password)
	  	.headers(header).
	  	//.cookie(cookie). (To send cookies)
	  	
	  when()
	  	.get("/Employee/AllEmployees").
	  then()
	  //every log will come before validation
	  .log().ifValidationFails()
	  .statusCode(200)
	  .extract().cookies();
	 
	 System.out.println(cook.get("Cookie name"));
	  
}
}
