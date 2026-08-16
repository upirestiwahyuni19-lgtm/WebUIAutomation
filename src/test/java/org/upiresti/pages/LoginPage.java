package org.upiresti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locator
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Membuka halaman login
    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    // Mengisi username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Mengisi password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Klik tombol login
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Membaca pesan error
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    // Mengecek apakah login berhasil
    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("inventory.html");
    }
}