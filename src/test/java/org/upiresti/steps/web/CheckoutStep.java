
package org.upiresti.steps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import org.upiresti.pages.ProductPage;
import org.upiresti.pages.CartPage;
import org.upiresti.pages.CheckoutPage;
import org.upiresti.support.DriverManager;

public class CheckoutStep {

    private WebDriver driver;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    private void initializePages() {
        driver = DriverManager.getDriver();

        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @And("user menambahkan Sauce Labs Backpack ke cart")
    public void userMenambahkanProductKeCart() {
        initializePages();

        productPage.addBackpackToCart();
    }

    @And("user membuka shopping cart")
    public void userMembukaShoppingCart() {
        productPage.openCart();

        Assertions.assertTrue(
                cartPage.isProductInCart(),
                "Product tidak ditemukan di cart"
        );

        Assertions.assertTrue(
                cartPage.isCorrectProductInCart(),
                "Produk yang ada di cart tidak sesuai"
        );

        System.out.println("Product berhasil ditambahkan ke cart");
    }

    @And("user melakukan checkout")
    public void userMelakukanCheckout() {

        cartPage.clickCheckout();

        System.out.println(
                "Checkout URL: " + driver.getCurrentUrl()
        );

        checkoutPage.waitForCheckoutPage();

        System.out.println(
                "Checkout Information page berhasil dibuka"
        );
    }



    @And("user mengisi informasi checkout")
    public void userMengisiInformasiCheckout() {

        checkoutPage.waitForCheckoutPage();

        checkoutPage.enterFirstName("Upi");
        checkoutPage.enterLastName("Resti");
        checkoutPage.enterPostalCode("12345");

        checkoutPage.clickContinue();

        System.out.println(
                "Checkout Overview berhasil dibuka"
        );
    }

    @And("user menyelesaikan order")
    public void userMenyelesaikanOrder() {
        checkoutPage.clickFinish();
    }

    @Then("order berhasil dibuat")
    public void orderBerhasilDibuat() {

        Assertions.assertTrue(
                checkoutPage.isCheckoutSuccessful(),
                "Checkout gagal atau order belum selesai"
        );

        System.out.println(
                "ORDER STATUS: " +
                        checkoutPage.getCompleteMessage()
        );
    }
}
