package com.rest.TestCase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rest.Base.Base;
import com.rest.Utilities.Util;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC_02_GET extends Base {

	/*
	 * @BeforeClass public void getAllEmployees() {
	 * logger.info("**********Started logging**************"); RestAssured.baseURI =
	 * "http://dummy.restapiexample.com/api/v1"; httpreq = RestAssured.given();
	 * response = httpreq.request(Method.GET, "/employee/10667"); }
	 * 
	 * @Test public void CheckResponseBody() throws InterruptedException {
	 * logger.info("Checking ==>> CheckResponseBody for Indivisual");
	 * 
	 * 
	 * String data = response.getBody().asString();
	 * 
	 * JsonPath json = response.getBody().jsonPath(); String emp_ID =
	 * json.get("name");
	 * 
	 * System.out.println("Generated Employee Name is :"+data); Thread.sleep(5000);
	 * 
	 * }
	 */
	String Employe = "10950";
	@Test(priority = 0)
	void Get_EmployeeID() throws InterruptedException {
		//String Employe = TC_03_POST.Validation_GetID();
		logger.info("Employee ID is :" + Employe);
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpreq = RestAssured.given();
		response = httpreq.request(Method.GET, "/employee/" + Employe);
		Thread.sleep(7000);

	}
	
	@Test(priority = 1)
	void CheckBody() throws InterruptedException {
		//String Employe = "10667";
		String ResponseBody = response.getBody().asString();
		logger.info("Response Body is :"+ResponseBody);
		JsonPath jp = response.jsonPath();
		String Emp_Name = jp.get("employee_name");
		//String name = Util.EmployeName();
		//String name ="PurnaQp";
		Assert.assertEquals(ResponseBody.contains(Employe), true);
	}
	
	
	
	
	
	
	
	
	
	

}
