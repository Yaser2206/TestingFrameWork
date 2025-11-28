package com.test.automation.web_api_framework;

import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

import com.test.automation.web_api_framework.OR_Flies.coursesPojo;


public class OauthPojo {
	private String url;
	private String services;
	private String expertise;
	private coursesPojo courses;
	private String linkedIn;
	private String instructor;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public coursesPojo getCourses() {
		return courses;
	}
	public void setCourses(coursesPojo courses) {
		this.courses = courses;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	// if we look into the response, we can see that courses have nested array of Json
	// we can condiser it as an nested Json object
//	{
//		  "instructor": "RahulShetty",
//		  "url": "rahulshettycademy.com",
//		  "services": "projectSupport",
//		  "expertise": "Automation",
//		  "courses": {
//		    "webAutomation": [
//		      {
//		        "courseTitle": "Selenium Webdriver Java",
//		        "price": "50"
//		      },
//		      {
//		        "courseTitle": "Cypress",
//		        "price": "40"
//		      },
//		      {
//		        "courseTitle": "Protractor",
//		        "price": "40"
//		      }
//		    ],
//		    "api": [
//		      {
//		        "courseTitle": "Rest Assured Automation using Java",
//		        "price": "50"
//		      },
//		      {
//		        "courseTitle": "SoapUI Webservices testing",
//		        "price": "40"
//		      }
//		    ],
//		    "mobile": [
//		      {
//		        "courseTitle": "Appium-Mobile Automation using Java",
//		        "price": "50"
//		      }
//		    ]
//		  },
//		  "linkedIn": "https://www.linkedin.com/in/rahul-shetty-trainer/"
//		}
//	Here, we can create separate POJO classes for webAutomation, api, and mobile courses and 
//	then include them in a Courses POJO class, we now need to inject that sub class pojo into parent pojo clASS,
//	it can done by changing the data type of courses variable from String to coursesPojo (as CoursesPojo is the class name
//	i.e, Private String courses;  -----> Private coursesPojo courses;
//	For ex- if we change the classname to CourseDetailsPojo then it will be like Private CourseDetailsPojo courses;
	
	
	
}
