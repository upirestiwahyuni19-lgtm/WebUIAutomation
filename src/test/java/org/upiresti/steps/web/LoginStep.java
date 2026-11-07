
package org.upiresti.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import org.upiresti.pages.LoginPage;
import org.upiresti.support.DriverManager;

public class LoginStep {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("user berada di halaman login")
    public void userBeradaDiHalamanLogin() {

        driver = DriverManager.getDriver();

        loginPage = new LoginPage(driver);

        loginPage.openLoginPage();

        System.out.println(
                "LOGIN URL: " + driver.getCurrentUrl()
        );
    }

    @When("user memasukkan username {string}")
    public void userMemasukkanUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("user memasukkan password {string}")
    public void userMemasukkanPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("user menekan tombol login")
    public void userMenekanTombolLogin() {
        loginPage.clickLogin();
    }

    @Then("user berhasil login")
    public void userBerhasilLogin() {

        Assertions.assertTrue(
                loginPage.isLoginSuccessful(),
                "User gagal login"
        );
    }

    @Then("muncul pesan error login")
    public void munculPesanErrorLogin() {

        String errorMessage = loginPage.getErrorMessage();

        Assertions.assertFalse(
                errorMessage.isEmpty(),
                "Pesan error tidak muncul"
        );

        System.out.println("Error: " + errorMessage);
    }
}
