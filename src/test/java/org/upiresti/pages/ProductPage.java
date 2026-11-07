
package org.upiresti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private WebDriver driver;

    private By backpackButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private By cartIcon =
            By.className("shopping_cart_link");

    private By productTitle =
            By.className("title");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {
        driver.findElement(backpackButton).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public boolean isInventoryPageDisplayed() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public boolean isBackpackSelected() {
        return getProductTitle().equals("Products");
    }
}
