package org.upiresti.steps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.upiresti.api.RegisterRequest;
import org.upiresti.api.LogInRequest;
import org.upiresti.api.LogoutRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterLoginApiStep {

    private String name;
    private String email;
    private String password;
    private String token;

    private Response registerResponse;
    private Response loginResponse;
    private Response logoutResponse;

    @Given("user baru melakukan register")
    public void userBaruMelakukanRegister() {

        name = "UPI";
        email = "automation" + System.currentTimeMillis() + "@example.com";
        password = "P@ssword123";

        System.out.println("Email: " + email);
    }

    @When("user melakukan register melalui API")
    public void userMelakukanRegisterMelaluiAPI() {

        String body = """
                {
                    "nama": "%s",
                    "email": "%s",
                    "password": "%s",
                    "password_confirmation": "%s"
                }
                """.formatted(name, email, password, password);

        System.out.println("========== REGISTER REQUEST ==========");
        System.out.println(body);

        registerResponse = RegisterRequest.register(body);

        System.out.println("========== REGISTER RESPONSE ==========");
        System.out.println("Status Code: " + registerResponse.statusCode());
        System.out.println("Response Body:");
        System.out.println(registerResponse.asPrettyString());
        System.out.println("======================================");
    }

    @Then("register berhasil dengan status code {int}")
    public void registerBerhasilDenganStatusCode(int expectedStatusCode) {

        assertThat(
                registerResponse.statusCode(),
                equalTo(expectedStatusCode)
        );
    }

    @When("user login menggunakan akun yang baru didaftarkan")
    public void userLoginMenggunakanAkunYangBaruDidaftarkan() {

        String body = """
                {
                    "email": "%s",
                    "password": "%s"
                }
                """.formatted(email, password);

        System.out.println("========== LOGIN REQUEST ==========");
        System.out.println(body);

        loginResponse = LogInRequest.login(body);

        token = loginResponse.jsonPath().getString("data.token");

        System.out.println("========== LOGIN RESPONSE ==========");
        System.out.println("Status Code: " + loginResponse.statusCode());
        System.out.println("Response Body:");
        System.out.println(loginResponse.asPrettyString());
        System.out.println("===================================");
    }

    @Then("login berhasil dengan status code {int}")
    public void loginBerhasilDenganStatusCode(int expectedStatusCode) {

        assertThat(
                loginResponse.statusCode(),
                equalTo(expectedStatusCode)
        );
    }

    @And("response success bernilai {word}")
    public void responseSuccessBernilai(String expectedSuccess) {

        boolean expected =
                Boolean.parseBoolean(expectedSuccess);

        assertThat(
                loginResponse.jsonPath().getBoolean("success"),
                equalTo(expected)
        );
    }

    @When("user melakukan logout melalui API")
    public void userMelakukanLogoutMelaluiAPI() {

        System.out.println("========== LOGOUT REQUEST ==========");

        logoutResponse = LogoutRequest.logout(token);

        System.out.println("========== LOGOUT RESPONSE ==========");
        System.out.println("Status Code: " + logoutResponse.statusCode());
        System.out.println("Response Body:");
        System.out.println(logoutResponse.asPrettyString());
        System.out.println("=====================================");
    }

    @Then("logout berhasil dengan status code {int}")
    public void logoutBerhasilDenganStatusCode(int expectedStatusCode) {

        assertThat(
                logoutResponse.statusCode(),
                equalTo(expectedStatusCode)
        );
    }

    @When("user login menggunakan password yang salah")
    public void userLoginMenggunakanPasswordYangSalah() {

        String wrongPassword = "WrongPassword123";

        String body = """
            {
                "email": "%s",
                "password": "%s"
            }
            """.formatted(email, wrongPassword);

        System.out.println("========== LOGIN NEGATIVE REQUEST ==========");
        System.out.println(body);

        loginResponse = LogInRequest.login(body);

        System.out.println("========== LOGIN NEGATIVE RESPONSE ==========");
        System.out.println("Status Code: " + loginResponse.statusCode());
        System.out.println("Response Body:");
        System.out.println(loginResponse.asPrettyString());
        System.out.println("============================================");
    }

    @Then("login gagal dengan status code {int}")
    public void loginGagalDenganStatusCode(int expectedStatusCode) {

        assertThat(
                loginResponse.statusCode(),
                equalTo(expectedStatusCode)
        );
    }
}