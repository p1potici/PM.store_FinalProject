package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    // Navigate to the product page
    public void goTo(String productUrl) {
        driver.get(productUrl);
    }

    // Add a product to the basket
    public void addToBasket() {
        try {
            Thread.sleep(3000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement addToCartButton = driver.findElement(By.cssSelector("a.btn-cart.custom.add2cartList.__retargetingAddToCartSelector"));
        addToCartButton.click();
    }

    // Proceed to the cart page
    public void openCart() {
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement cartButton = driver.findElement(By.cssSelector("li.cart-header-btn.cart > a"));
        cartButton.click();
    }

    public void proceedToCheckout() {
        // Click the checkout button
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a.btn.btn-cmd.full.fr.-g-order-checkout-button")));
        checkoutButton.click();

    }
}
