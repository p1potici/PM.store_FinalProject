package tests;

import data.CheckoutDataProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.LoggOffPage;

/**
 * End-to-end test for filling out the checkout form and logging off.
 */
class E2E_CheckoutTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;
    private LoggOffPage loggOffPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loggOffPage = new LoggOffPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.CheckoutDataProvider#validCheckoutData")
    void testCheckoutFormAndLogOff(String email, String lastName, String firstName, String phone, String county, String city, String address) {
        // Step 1: Navigate to the homepage and login
        loginPage.goTo();
        loginPage.clickLoginButton();
        loginPage.fillLoginForm(email, "Test123!");
        loginPage.clickLogin_Button();
        System.out.println("Logged in successfully.");

        // Step 2: Navigate to the product page and add to basket
        productPage.openDropdownMenu();
        productPage.navigateToGamingCategory();// Navigate to the 2nd category in the dropdown
        productPage.addToBasket();
        System.out.println("Added product to basket.");
        // Step 3: Open the basket and proceed to checkout
        productPage.openCart();
        waitFor(1000, "Waiting before proceeding to checkout.");
        productPage.proceedToCheckout();
        System.out.println("Proceeded to checkout.");
        // Step 4: Fill out the checkout form
        checkoutPage.fillContactInformation(email, lastName, firstName, phone);
        checkoutPage.fillDeliveryInformation(county, city, address);
        checkoutPage.agreeToPolicy();
        System.out.println("Filled out the checkout form.");
        // Step 5: Log off
        loggOffPage.logOff();
        System.out.println("User logged off via LogOffPage.");
    }

    // Helper to simulate waiting for user actions
    private void waitFor(int milliseconds, String message) {
        try {
            Thread.sleep(milliseconds);
            System.out.println(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
