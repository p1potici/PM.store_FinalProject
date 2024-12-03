package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.ProductPage;
import utils.webUtils;

class E2E_MainTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeEach
    void setup() {
        driver = webUtils.getWebDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    void endToEndFlowTest1() {
        // Step 1: Go to the homepage
        loginPage.goTo();
        System.out.println("Navigated to homepage.");

        // Step 2: Login
        loginPage.clickLoginButton();
        loginPage.fillLoginForm("John.Doee@example.com", "Test123!"); // Use valid credentials from LoginDataProvider
        loginPage.clickLogin_Button();
        System.out.println("Logged in successfully.");

        // Step 3: Navigate to a section using a dropdown menu
        WebElement dropdownMenu = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > a")); // Adjust selector as needed
        dropdownMenu.click();
        WebElement dropdownLink = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > div > ul > li:nth-child(8) > a > span")); // Update selector
        dropdownLink.click();
        System.out.println("Accessed the product page via dropdown menu.");

        // Step 4: Add product to basket
        productPage.addToBasket();
        System.out.println("Product added to basket.");

        // Step 5: Wait and navigate to the basket
        try {
            Thread.sleep(5000); // Timer from add to basket to basket
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productPage.openCart();
        System.out.println("Opened basket.");

        // Step 6: Log off via the account section
        WebElement accountMenu = driver.findElement(By.cssSelector("#wrapper > header > div > div > div > div.col-sm-6.col-xs-12.cart-menu > ul > li.-g-user-icon.-g-user-loggedin-icon > a > span")); // Adjust selector
        accountMenu.click();
        WebElement logoutButton = driver.findElement(By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul:nth-child(5) > li > a")); // Adjust selector
        logoutButton.click();
        System.out.println("Logged off successfully.");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
