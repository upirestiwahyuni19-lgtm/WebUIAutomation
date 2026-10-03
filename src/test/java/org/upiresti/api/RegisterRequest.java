package org.upiresti.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RegisterRequest {

    private static final String BASE_URL = "https://api.rizqifauzan.com";

    public static Response register(String body) {

        return given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(body)
                .when()
                .post("/api/auth/register");
    }
}