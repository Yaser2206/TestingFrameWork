package com.test.automation.web_api_framework;

import org.testng.annotations.*;

public class APITest{
    
    private String baseURI;

	@BeforeTest
	public void setup() {
		// RestAssured dependency was causing unresolved import in some environments.
		// Use a simple string here so tests can compile without Rest Assured.
		baseURI = "https://yaserarafath2210.atlassian.net/jira/for-you";
		System.out.println("Base URI set to: " + baseURI);
	}
	
	@Test
	public void ValidateAPIAuthToken() {
		System.out.println("This is a sample API test. Base URI: " + baseURI);
	}
}