package com.test.automation.web_api_framework;

import java.io.File;

import org.testng.annotations.Test;

import com.test.automation.web_api_framework.OR_Flies.JiraAPITest_OR;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class JiraAPITest {
	JiraAPITest_OR jiraOR=new JiraAPITest_OR();
	
	String URI=jiraOR.baseURI;
	int IdCreated=0;
	
	@Test
	public void createBug() {
		String resource="/rest/api/3/issue";
		RestAssured.baseURI=URI;
		// print the full URL for debugging (helps compare with Postman)
		System.out.println("Request URL: " + RestAssured.baseURI + resource);
		String response=
		RestAssured.given().relaxedHTTPSValidation()
			.header("Authorization", jiraOR.APIEncodedToken)
			.header("Content-Type","application/json")
			.accept("application/json")
			.body(jiraOR.body)
		.when().post(resource).then().assertThat().statusCode(201).extract().response().asString();
		System.out.println("Response is :"+response);
		JsonPath js=new JsonPath(response);
		String id=js.getString("id");
		System.out.println("Created issue id is :"+id);
		IdCreated=Integer.parseInt(id);
	}
	
	@Test
	public void createBugWithAttachment() {
		String workindDir=System.getProperty("user.dir");
		System.out.println("Working Directory is :"+workindDir+"src\\test\\resources\\Utils\\TestDoc.txt");
		workindDir=workindDir+"\\src\\test\\resources\\Utils\\TestDoc.txt";
		File file=new File(workindDir);
		System.out.println(file.getAbsolutePath());
		createBug();
		String resource="/rest/api/3/issue/{key}/attachments";
		String response=RestAssured.given().relaxedHTTPSValidation()
			.header("Authorization", jiraOR.APIEncodedToken).pathParam("key",IdCreated)
			.header("X-Atlassian-Token","no-check")
			.header("Content-Type","multipart/form-data")
			.accept("application/json")
			.multiPart("file",file)
		.log().all().when().post(resource).then().assertThat().statusCode(200).extract().response().asString();
		System.out.println("Response with attachment is :"+response);
	}
	
	@Test
	public void getBug() {
		createBugWithAttachment();
		String resource="/rest/api/3/issue/{key}";
		String response=RestAssured.given().relaxedHTTPSValidation().header("Authorization",jiraOR.APIEncodedToken).
		pathParam("key",IdCreated).
		header("Content-Type","application/json").when().get(resource).then().assertThat().statusCode(200).
		extract().response().asString();
		
		System.out.println("Get Bug Response is :"+response);
	}
	
}