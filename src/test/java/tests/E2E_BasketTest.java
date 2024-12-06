package tests;

import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.ProductPage;
import pages.LoggOffPage;
import org.junit.jupiter.api.Test;

public class E2E_BasketTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;
    private LoggOffPage loggOffPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        loggOffPage = new LoggOffPage(driver);
    }

    @Test
    void endToEndFlowTest1() {
        // Step 1: Log in
        loginPage.goTo();
        loginPage.clickLoginButton();
        loginPage.fillLoginForm("John.Doee@example.com", "Test123!");
        loginPage.clickLogin_Button();
        productPage.openDropdownMenu();
        productPage.navigateToGamingCategory();
        // Step 3: Add product
        productPage.addToBasket();
        // Step 4: Open basket
        productPage.openCart();
        // Step 5: Log off
        loggOffPage.logOff();
        System.out.println("LogOffPage.");
        System.out.println("Succesful: Logg of");
    }
}
