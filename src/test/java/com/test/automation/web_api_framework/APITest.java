package com.test.automation.web_api_framework;

import org.testng.annotations.*;

import io.restassured.RestAssured;
//Yaser:ATATT3xFfGF0Alp0r_t-2yhFg13jgu3w6jm_2R_QcdJru8xCC3Ix-TKYLE8XFJu07m0eZP-Jokg7L_GryP1V0TVO_-VBqiCWqjqvRIxAra6FU6jeiJ2ePfNxr3PVvGNLCK8_FaghHhFOshv1caiiTxPu868VuxeCHFvlH4UMkEzpLIFDgYbpSsw=6A094972
// encoded:
// WWFzZXI6QVRBVFQzeEZmR0YwQWxwMHJfdC0yeWhGZzEzamd1M3c2am1fMlJfUWNkSnJ1OHhDQzNJeC1US1lMRThYRkp1MDdtMGVaUC1Kb2tnN0xfR3J5UDFWMFRWT18tVkJxaUNXcWpxdlJJeEFyYTZGVTZqZWlKMmVQZk54cjNQVnZHTkxDSzhfRmFnaEhoRk9zaHYxY2FpaVR4UHU4NjhWdXhlQ0hGdmxINFVNa0V6cExJRkRnWWJwU3N3PTZBMDk0OTcy

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