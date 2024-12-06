package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.LoggOffPage;


/**
 * End-to-end test for adjusting product quantity in the basket and logging off.
 */
class E2E_QuantityTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;
    private LoggOffPage logOffPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        logOffPage = new LoggOffPage(driver);
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
        productPage.navigateToGamingCategory();
        System.out.println("Accessed the product page via dropdown menu.");
        // Step 3: Add a product
        productPage.addToBasket();
        System.out.println("Added product to basket.");
        // Step 4: Open the basket
        productPage.openCart();
        System.out.println("Opened basket.");
        // Step 5: Adjust the product quantity
        productPage.adjustQuantityInBasket();
        // Step 7: Log off
        logOffPage.logOff();
        System.out.println("Logged off successfully.");
    }

    /**
     * Adjusts the product quantity in the basket.
     */

    }


