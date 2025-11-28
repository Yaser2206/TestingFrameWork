package com.test.automation.web_api_framework.OR_Flies;

import static io.restassured.RestAssured.given;

public class OauthApiTest_OR {
	public static final String client_id="692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com";
	public static final String client_secret="erZOWM9g3UtwNRj340YYaK_W";
	public static final String scope="trust";
	public static final String grant_type="client_credentials";
	public static final String tokenURL="https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token";
	
	public  String accessTokenRetrieve(String ClientId, String ClientSecret, String Scope, String GrantType, String TokenURL) {
		String resonse=
		given().formParam("client_id", ClientId).
		formParam("client_secret",ClientSecret ).formParam("Scope", Scope).
		formParam("grant_type", GrantType).when().log().all().
		post(TokenURL).then().extract().asString();
		return resonse;
	}
}
