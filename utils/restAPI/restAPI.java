package com.test.automation.web_api_framework.utils.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

/**
 * Lightweight Rest Assured utility with reusable static helpers for tests.
 * Place under test sources so it can depend on Rest Assured (test scope).
 */
public final class restAPI {

    private RestAssuredUtil() { /* utility class */ }

    /**
     * Create a base RequestSpecification with sane defaults.
     *
     * @param baseUri base URI (may be null)
     * @param headers optional headers
     * @return configured RequestSpecification
     */
    public static RequestSpecification requestSpec(String baseUri, Map<String, String> headers) {
        RequestSpecification req = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);

        if (baseUri != null && !baseUri.isEmpty()) {
            req.baseUri(baseUri);
        }

        if (headers != null && !headers.isEmpty()) {
            req.headers(headers);
        }

        return req;
    }

    public static Response get(String baseUri, String path, Map<String, String> headers, Map<String, ?> queryParams) {
        RequestSpecification req = requestSpec(baseUri, headers);
        if (queryParams != null && !queryParams.isEmpty()) {
            req.queryParams(queryParams);
        }
        return req.when().get(path).then().extract().response();
    }

    public static Response post(String baseUri, String path, Map<String, String> headers, Object body) {
        RequestSpecification req = requestSpec(baseUri, headers);
        if (body != null) req.body(body);
        return req.when().post(path).then().extract().response();
    }

    public static Response put(String baseUri, String path, Map<String, String> headers, Object body) {
        RequestSpecification req = requestSpec(baseUri, headers);
        if (body != null) req.body(body);
        return req.when().put(path).then().extract().response();
    }

    public static Response delete(String baseUri, String path, Map<String, String> headers) {
        RequestSpecification req = requestSpec(baseUri, headers);
        return req.when().delete(path).then().extract().response();
    }

    // Convenience extractors
    public static int statusCode(Response response) {
        return response.getStatusCode();
    }

    public static String asString(Response response) {
        return response.asString();
    }

    public static <T> T jsonPath(Response response, String path, Class<T> clazz) {
        return response.jsonPath().getObject(path, clazz);
    }

    public static String jsonPathString(Response response, String path) {
        return response.jsonPath().getString(path);
    }
}
