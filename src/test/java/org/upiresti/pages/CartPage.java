
package org.upiresti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;

    private WebDriverWait wait;

    private By cartItem =
            By.className("inventory_item_name");

    private By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver, Duration.ofSeconds(15)
        );
    }

    public String getCartProductName() {

        return wait.until(d -> {
            try {
                return d.findElement(cartItem).getText();
            } catch (StaleElementReferenceException e) {
                return null;
            }
        });
    }


    public void clickCheckout() {

        System.out.println("\n===== CHECKOUT DIAGNOSTIC =====");

        System.out.println("URL: " + driver.getCurrentUrl());

        System.out.println("TITLE: " + driver.getTitle());

        System.out.println("SESSION: " +
                ((org.openqa.selenium.remote.RemoteWebDriver) driver)
                        .getSessionId());

        System.out.println("CART ITEMS: " +
                driver.findElements(cartItem).size());

        var buttons = driver.findElements(checkoutButton);

        System.out.println("CHECKOUT COUNT: " + buttons.size());

        if (!buttons.isEmpty()) {

            var button = buttons.get(0);

            System.out.println("DISPLAYED: " + button.isDisplayed());

            System.out.println("ENABLED: " + button.isEnabled());

            System.out.println("TEXT: " + button.getText());
        }

        System.out.println("===============================\n");

        wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .visibilityOfElementLocated(checkoutButton)
        );

        wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .elementToBeClickable(checkoutButton)
        ).click();

        System.out.println("CHECKOUT CLICKED!");
    }



    public boolean isProductInCart() {

        return wait.until(d ->
                d.findElements(cartItem).size() > 0
        );
    }

    public boolean isCorrectProductInCart() {

        String productName = getCartProductName();

        return productName.equals("Sauce Labs Backpack");
    }
}
