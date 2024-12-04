package tests;

import org.junit.jupiter.api.*;
import pages.ProductPage;
import org.junit.jupiter.api.Test;

class BasketTest extends BaseTest {
    private ProductPage productPage;

    @BeforeEach
    void testSetup() {
        productPage = new ProductPage(driver);
    }

    @Test
    void testAddToBasketAndCheckout() {
        // Step 1: Navigate to product page
        productPage.goTo("https://www.pmstore.ro/gaming");

        // Step 2: Add product to basket
        productPage.addToBasket();

        // Step 3: Open basket
        productPage.openCart();

        // Step 4: Proceed to checkout
        productPage.proceedToCheckout();

        System.out.println("Test completed: Add to basket and checkout.");
    }
}
