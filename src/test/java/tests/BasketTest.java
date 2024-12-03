package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import utils.webUtils;

class BasketTest {
    private WebDriver driver;
    private ProductPage productPage;

    @BeforeEach
    void setup() {
        driver = webUtils.getWebDriver();
        productPage = new ProductPage(driver);
    }

    @Test
    void testAddToBasketAndCheckout() {
        // Navigate to product page
        productPage.goTo("https://www.pmstore.ro/gaming");

        // Add product to basket
        productPage.addToBasket();

        // Open the cart
        productPage.openCart();

        // Proceed to checkout
        productPage.proceedToCheckout();

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
