package com.rest.TestCase;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.rest.Base.Base;
import com.rest.Utilities.Util;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC_03_POST extends Base{
		String EmpName = Util.EmployeName();
		String EmpAge = Util.EmployeAge();
		String EmpSal = Util.EmployeSalary();
	
		
		
		@Test(priority = 0)
		public void Post() throws InterruptedException {
			logger.info("****************** Starting of Post Method  ******************************");
			RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
			httpreq = RestAssured.given();
			logger.info("Entered Employee Name :"+EmpName);
			logger.info("Entered Employee Salary :"+EmpSal);
			logger.info("Entered Employee Age :"+EmpAge);
			JSONObject jo = new JSONObject();
			jo.put("name", EmpName);
			jo.put("salary", EmpSal);
			jo.put("age", EmpAge);
			//{"name":"test","salary":"123","age":"23"}
			httpreq.header("Content-Type","application/json");
			httpreq.body(jo.toJSONString());
			response = httpreq.request(Method.POST,"/create");
			Thread.sleep(5000);
			logger.info("Generated EMP ID :"+TC_03_POST.Validation_GetID());
			
		}
		
		@Test(priority = 1)
		public void Validation_ByBody() {
			logger.info("Validation_ByBody");
			String data = response.getBody().asString();
			logger.info("Complete data :"+data);
			Assert.assertEquals(data.contains(EmpName), true);
			Assert.assertEquals(data.contains(EmpSal), true);
			Assert.assertEquals(data.contains(EmpAge), true);
			int code = response.getStatusCode();
			logger.info("Status Code is : "+code);
			
			Assert.assertEquals(200, code);
			
			
		}
		
		public  static String Validation_GetID() throws InterruptedException {
			JsonPath json = response.jsonPath();
			String emp_ID = json.get("id");
			System.out.println("Generated Employee ID is :"+emp_ID);
			Thread.sleep(5000);
			return emp_ID;
			
		}
		
		@Test(priority = 3)
		public void CheckResponseTiming() {
			logger.info("Checking ==>> CheckResponseTiming__3");
			long responseTime = response.getTime();
			if(responseTime>=500) {
				logger.warn("Response timing is more than 500 and the same is :"+responseTime);
			}else {
				logger.info("Response timing ==>"+responseTime);
			}
		}
		
		@Test(priority = 4)
		public void checkStatusLine() {
			logger.info("Checking ==>> checkStatusLine__4");
			String StatusLine = response.getStatusLine();
			logger.info("Status line is :"+StatusLine);
			
		}
		
		
		@Test(priority = 5)
		public void checkContentType(){
			logger.info("Checking ==>> checkContentType__5");
			String head = response.header("content-type");
			logger.info("Headers is :"+head);
			Assert.assertEquals(head, "text/html; charset=UTF-8");
			
		}
		
		@Test(priority = 6)
		public void checkResponseServer(){
			logger.info("Checking ==>> checkResponseServer__6");
			String head = response.header("Server");
			logger.info("Headers is :"+head);
			
		}
		
		
		@Test(priority = 7)
		public void checkContentEncoding(){
			logger.info("Checking ==>> checkContentEncoding__7");
			String head = response.header("Content-Length");
			logger.info("Headers is :"+head);
			
		}
		
		@Test(priority = 8)
		public void checkContentLength(){
			logger.info("Checking ==>> checkContentLength__8");
			String head = response.header("Content-Encoding");
			logger.info("Headers is :"+head);
			
		}
		
		
		@AfterClass
		public void tearDown() {
			logger.info("****************************** Completed POST Method ******************************");
		}
		
		
}
