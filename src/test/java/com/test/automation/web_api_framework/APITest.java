package com.test.automation.web_api_framework;

import org.testng.annotations.*;

import io.restassured.RestAssured;


public class APITest{
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI="https://yaserarafath2210.atlassian.net/jira/for-you";
	}
	
	@Test
	public void ValidateAPIAuthToken() {
		System.out.println("This is a sample API test.");
	}
}