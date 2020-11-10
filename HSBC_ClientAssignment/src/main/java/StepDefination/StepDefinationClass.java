package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class StepDefinationClass {
	Response res;
	
	@Given("Rates API for latest foreign exchange rates")
	public void setUpAPI() {
		RestAssured.baseURI ="https://api.ratesapi.io/api";
	}

	@When("The API is Available")
	public void invokeAPI() {
	   res=  RestAssured.given().header("Content-Type", "application/json")
			   .when().get("/latest")
			   .then().log().all().assertThat().statusCode(200).extract().response();
	     
	}

	@Then("Verify the success status code of the response is success")
	public void validateAPIStatus() {
		
		//Applying Assert to validate the status code
		 Assert.assertEquals(200, res.getStatusCode());
	    
		 //Printing the status code
		 System.out.println("Status Code of Response is :" + res.getStatusCode());

	}
	@Then("Verify the success status code of the response is success")
	public void validateAPIStatus() {
		
		//Applying Assert to validate the status code
		 Assert.assertEquals(200, res.getStatusCode());
	    
		 //Printing the status code
		 System.out.println("Status Code of Response is :" + res.getStatusCode());
		 

	}

	@Then("validate response for negative response")
	public void validate_response_for_negative_response() {
		 Assert.assertEquals(400, res.getStatusCode());
		 RestAssured.when().get("https://api.ratesapi.io/api/lates").then().log().all();
		
	}
	
	@Then("validate future positive response received")
	public void validate_future_positive_response_received() {
		 Assert.assertEquals(200, res.getStatusCode());
		   Assert.assertEquals( "application/json",res.getContentType());
		RestAssured.given().when().get("https://api.ratesapi.io/api/2022-01-12").then().body("date", equalTo("2020-11-06"));
	
	}

}
