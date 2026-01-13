package com.locators.HRM;


import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GETApiRequest {
	@Test
	public void GetAllbookings() {
		
		Response response =
		
		RestAssured
				.given()
					.contentType(ContentType.JSON)
					.baseUri("https://restful-booker.herokuapp.com")
				.when()
					.get("/booking")
				.then()
				    
				    .assertThat()
				    .statusCode(200)
				    .statusLine("HTTP/1.1 200 OK")
				    .header("Content-Type", "application/json; charset=utf-8")
				.extract()
					.response();
		
		Assert.assertTrue(response.getBody().asString().contains("bookingid"));

		
	}

}
