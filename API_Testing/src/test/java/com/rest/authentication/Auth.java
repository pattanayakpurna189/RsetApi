package com.rest.authentication;

import org.testng.annotations.Test;

import com.rest.Base.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Auth extends Base {

	
	
	@Test
	public void Auth() {
		RestAssured.baseURI = "http://restapi.demoqa.com";
		httpreq = RestAssured.given();
		httpreq.auth().preemptive().basic("ToolsQA", "TestPassword");
		response = httpreq.request(Method.GET, "/authentication/CheckForAuthentication");
		int status = response.getStatusCode();
		System.out.println("Status code is :"+status);
		logger.info("Status code is :"+status);
	}
}
