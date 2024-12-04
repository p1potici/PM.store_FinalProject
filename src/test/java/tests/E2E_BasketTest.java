package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.ProductPage;
import org.junit.jupiter.api.Test;

public class E2E_BasketTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    void endToEndFlowTest1() {
        // Step 1: Log in
        loginPage.goTo();
        loginPage.clickLoginButton();
        loginPage.fillLoginForm("John.Doee@example.com", "Test123!");
        loginPage.clickLogin_Button();

        // Step 2: Navigate to product
        WebElement dropdownMenu = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > a"));
        dropdownMenu.click();
        WebElement dropdownLink = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > div > ul > li:nth-child(8) > a > span"));
        dropdownLink.click();

        // Step 3: Add product
        productPage.addToBasket();

        // Step 4: Open basket
        productPage.openCart();

        // Step 5: Log off
        WebElement accountMenu = driver.findElement(By.cssSelector("#wrapper > header > div > div > div > div.col-sm-6.col-xs-12.cart-menu > ul > li.-g-user-icon.-g-user-loggedin-icon > a > span"));
        accountMenu.click();
        WebElement logoutButton = driver.findElement(By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul:nth-child(5) > li > a"));
        logoutButton.click();

        System.out.println("Test completed: End-to-end flow.");
    }
}
