
package org.upiresti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");

    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    private By errorMessage = By.cssSelector("[data-test='error']");

    private By completeHeader =
            By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitForCheckoutPage() {

        wait.until(
                ExpectedConditions.urlContains(
                        "checkout-step-one.html"
                )
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        firstNameField
                )
        );
    }

    public void enterFirstName(String firstName) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstNameField)
        );
        field.clear();
        field.sendKeys(firstName);

        System.out.println("First Name: " + field.getAttribute("value"));
    }

    public void enterLastName(String lastName) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastNameField)
        );
        field.clear();
        field.sendKeys(lastName);

        System.out.println("Last Name: " + field.getAttribute("value"));
    }

    public void enterPostalCode(String postalCode) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(postalCodeField)
        );
        field.clear();
        field.sendKeys(postalCode);

        System.out.println("Postal Code: " + field.getAttribute("value"));
    }

    public void clickContinue() {

        wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        ).click();

        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("checkout-step-two.html"),
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        ));

        if (driver.getCurrentUrl().contains("checkout-step-two.html")) {
            System.out.println("Berhasil masuk Checkout Step Two");
        } else {
            System.out.println("Checkout validation error: "
                    + driver.findElement(errorMessage).getText());
        }
    }

    public void clickFinish() {
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        finishButton
                )
        ).click();

        wait.until(
                ExpectedConditions.urlContains(
                        "checkout-complete.html"
                )
        );
    }

    public String getCompleteMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        completeHeader
                )
        ).getText();
    }

    public boolean isCheckoutSuccessful() {
        return driver.getCurrentUrl()
                .contains("checkout-complete.html")
                && getCompleteMessage()
                .equals("Thank you for your order!");
    }
}
