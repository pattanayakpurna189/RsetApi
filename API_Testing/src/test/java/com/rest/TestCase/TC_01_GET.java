package com.rest.TestCase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rest.Base.Base;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;

public class TC_01_GET extends Base{

	@BeforeClass
	public void getAllEmployees() {
		logger.info("**********Started logging**************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpreq = RestAssured.given();
		response = httpreq.request(Method.GET, "/employees");
	}
	
	@Test
	public void CheckResponseBody() {
		logger.info("Checking ==>> CheckResponseBody__1");
		String data = response.getBody().asString();
		logger.info("Complete data :"+data);
		
	}
	
	@Test
	public void CheckStatusCode() {
		logger.info("Checking ==>> CheckStatusCode__2");
		int code = response.getStatusCode();
		logger.info("Status Code is : "+code);
		
	}

	@Test
	public void CheckResponseTiming() {
		logger.info("Checking ==>> CheckResponseTiming__3");
		long responseTime = response.getTime();
		if(responseTime>=500) {
			logger.warn("Response timing is more than 500 and the same is :"+responseTime);
		}else {
			logger.info("Response timing ==>"+responseTime);
		}
	}
	
	@Test
	public void checkStatusLine() {
		logger.info("Checking ==>> checkStatusLine__4");
		String StatusLine = response.getStatusLine();
		logger.info("Status line is :"+StatusLine);
		
	}
	
	
	@Test
	public void checkContentType(){
		logger.info("Checking ==>> checkContentType__5");
		String head = response.header("content-type");
		logger.info("Headers is :"+head);
		Assert.assertEquals(head, "text/html; charset=UTF-8");
		
	}
	
	@Test
	public void checkResponseServer(){
		logger.info("Checking ==>> checkResponseServer__6");
		String head = response.header("Server");
		logger.info("Headers is :"+head);
		
	}
	
	
	@Test
	public void checkContentEncoding(){
		logger.info("Checking ==>> checkContentEncoding__7");
		String head = response.header("Content-Length");
		logger.info("Headers is :"+head);
		
	}
	
	@Test
	public void checkContentLength(){
		logger.info("Checking ==>> checkContentLength__8");
		String head = response.header("Content-Encoding");
		logger.info("Headers is :"+head);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
