package org.upiresti.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.upiresti.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginStep {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        boolean isCI = System.getenv("GITHUB_ACTIONS") != null;

        if (isCI) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

        }
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        loginPage = new LoginPage(driver);
    }

    @Given("user berada di halaman login")
    public void userBeradaDiHalamanLogin() {
        loginPage.openLoginPage();
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

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}