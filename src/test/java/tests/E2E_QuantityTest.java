package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.ProductPage;
import org.junit.jupiter.api.Test;

class E2E_QuantityTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    void adjustQuantityAndCheckoutTest() {
        // Step 1: Log in
        loginPage.goTo();
        loginPage.clickLoginButton();
        loginPage.fillLoginForm("John.Doee@example.com", "Test123!");
        loginPage.clickLogin_Button();
        System.out.println("Logged in successfully.");

        // Step 2: Navigate to the product
        WebElement dropdownMenu = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > a"));
        dropdownMenu.click();
        WebElement dropdownLink = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > div > ul > li:nth-child(8) > a > span"));
        dropdownLink.click();
        System.out.println("Accessed the product page via dropdown menu.");

        // Step 3: Add a product
        productPage.addToBasket();
        System.out.println("Added product to basket.");

        // Step 4: basket
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productPage.openCart();
        System.out.println("Opened basket.");

        // Step 5: Adjust the product
        WebElement plusButton = driver.findElement(By.cssSelector("#updateCart > div.-g-checkout-summary > div.cart-box.col-sm.clearfix > ul.cart-items.clearfix.order > li > div.qty-h.col-sm-3.col-xs-6 > div.qty-regulator.clearfix.-g-product-qty-regulator-86 > a.number-up.plus.updateCart.-g-no-url"));
        plusButton.click();
        System.out.println("Increased quantity by 1.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement minusButton = driver.findElement(By.cssSelector("#updateCart > div.-g-checkout-summary > div.cart-box.col-sm.clearfix > ul.cart-items.clearfix.order > li > div.qty-h.col-sm-3.col-xs-6 > div.qty-regulator.clearfix.-g-product-qty-regulator-86 > a.minus.number-down.updateCart.-g-no-url > i"));
        minusButton.click();
        System.out.println("Reduced quantity by 1.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 6: Proceed to checkout
        WebElement checkoutButton = driver.findElement(By.cssSelector("#shoppingcart > a.btn.btn-cmd.full.fr.-g-order-checkout-button"));
        checkoutButton.click();
        System.out.println("Proceeded to checkout.");

        // Step 7: Log off
        WebElement accountMenu = driver.findElement(By.cssSelector("#wrapper > header > div > div > div > div.col-sm-6.col-xs-12.cart-menu > ul > li.-g-user-icon.-g-user-loggedin-icon > a > span"));
        accountMenu.click();
        WebElement logoutButton = driver.findElement(By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul:nth-child(5) > li > a"));
        logoutButton.click();
        System.out.println("Logged off successfully.");
    }
}
