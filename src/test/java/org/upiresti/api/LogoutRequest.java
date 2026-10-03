package org.upiresti.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class LogoutRequest {

    private static final String BASE_URL = "https://api.rizqifauzan.com";

    public static Response logout(String token) {

        return given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .when()
                .post("/api/auth/logout");
    }
}