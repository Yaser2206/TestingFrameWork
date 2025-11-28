package com.test.automation.web_api_framework;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.automation.web_api_framework.OR_Flies.OauthApiTest_OR;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
public class OauthApiTest {
	// make the OR object an instance field so tests can call non-static methods on it
	private OauthApiTest_OR oauthOR;

	@BeforeMethod
	public void loadOR() {
		// Load Object Repository or any necessary setup before each test
		oauthOR = new OauthApiTest_OR();
	}
	
	@Test
	public void accessApiWithOauth() {
		String client_id=OauthApiTest_OR.client_id;
		String client_secret=OauthApiTest_OR.client_secret;
		String scope=OauthApiTest_OR.scope;
		String grant_type=OauthApiTest_OR.grant_type;
		String tokenURL=OauthApiTest_OR.tokenURL;
		String response = "";
		try {
			// call the instance method on oauthOR instead of statically on the class
			response = oauthOR.accessTokenRetrieve( client_id,  client_secret,  scope,  grant_type,  tokenURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String token="";
		JsonPath js=new JsonPath(response);
		token=js.getString("access_token");
		System.out.println("Token: "+token);
		 String r2=
		given().queryParam("access_token", token).when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
		.then().log().all().extract().response().asString();
		 System.out.println("Response from API is :"+r2);
	}
//	The response of Json is like below:
//	{
//	  "instructor": "RahulShetty",
//	  "url": "rahulshettycademy.com",
//	  "services": "projectSupport",
//	  "expertise": "Automation",
//	  "courses": {
//	    "webAutomation": [
//	      {
//	        "courseTitle": "Selenium Webdriver Java",
//	        "price": "50"
//	      },
//	      {
//	        "courseTitle": "Cypress",
//	        "price": "40"
//	      },
//	      {
//	        "courseTitle": "Protractor",
//	        "price": "40"
//	      }
//	    ],
//	    "api": [
//	      {
//	        "courseTitle": "Rest Assured Automation using Java",
//	        "price": "50"
//	      },
//	      {
//	        "courseTitle": "SoapUI Webservices testing",
//	        "price": "40"
//	      }
//	    ],
//	    "mobile": [
//	      {
//	        "courseTitle": "Appium-Mobile Automation using Java",
//	        "price": "50"
//	      }
//	    ]
//	  },
//	  "linkedIn": "https://www.linkedin.com/in/rahul-shetty-trainer/"
//	}
}