package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object for handling product-related actions.
 */
public class ProductPage {
    private final WebDriver driver;

    // Selectors
    private final By dropdownMenuSelector = By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > a");
    private final By gamingCategorySelector = By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > div > ul > li:nth-child(8) > a > span");
    private final By addToBasketButtonSelector = By.cssSelector("#category-page > div > div:nth-child(3) > div.product-listing.clearfix > div.row.product > div.product-box.center.col-md-4.col-xs-6.dataProductId.__GomagListingProductBox.-g-product-box-86.-g-product-box-ajax-complete > div > div.figcaption.list-f > div.bottom-side-box > div.add-list.clearfix > a.btn.btn-cmd.btn-cart.custom.add2cartList.__retargetingAddToCartSelector._addToCartListProduct_86.-g-product-list-add-cart-86.-g-product-add-to-cart.-g-no-url");
    private final By cartButtonSelector = By.cssSelector("#wrapper > header > div.top-head-bg.container-h.full > div > div > div.col-md-5.col-sm-5.acount-section > ul > li.cart-header-btn.cart > a");
    private final By proceedToCheckoutButtonSelector = By.cssSelector("#shoppingcart > a.btn.btn-cmd.full.fr.-g-order-checkout-button");
    private final By plusButtonSelector = By.cssSelector("#updateCart > div.-g-checkout-summary > div.cart-box.col-sm.clearfix > ul.cart-items.clearfix.order > li > div.qty-h.col-sm-3.col-xs-6 > div.qty-regulator.clearfix.-g-product-qty-regulator-86 > a.number-up.plus.updateCart.-g-no-url");
    private final By minusButtonSelector = By.cssSelector("#updateCart > div.-g-checkout-summary > div.cart-box.col-sm.clearfix > ul.cart-items.clearfix.order > li > div.qty-h.col-sm-3.col-xs-6 > div.qty-regulator.clearfix.-g-product-qty-regulator-86 > a.minus.number-down.updateCart.-g-no-url > i");

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions

    /**
     * Opens the dropdown menu.
     */
    public void openDropdownMenu() {
        WebElement dropdownMenu = driver.findElement(dropdownMenuSelector);
        dropdownMenu.click();
        System.out.println("Opened dropdown menu.");
    }

    /**
     * Navigates to the Gaming category in the dropdown menu.
     */
    public void navigateToGamingCategory() {
        openDropdownMenu();
        WebElement gamingCategory = driver.findElement(gamingCategorySelector);
        gamingCategory.click();
        System.out.println("Navigated to the Gaming category.");
    }

    /**
     * Adds a product to the basket and waits for a delay.
     */
    public void addToBasket() {
        WebElement addToBasketButton = driver.findElement(addToBasketButtonSelector);
        addToBasketButton.click();
        System.out.println("Added product to basket.");

        // Wait to simulate user delay
        try {
            Thread.sleep(2000); // Wait for 2 seconds
            System.out.println("Waited for 2 seconds after adding to basket.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted during wait after adding to basket.");
        }
    }

    /**
     * Opens the cart.
     */
    public void openCart() {
        WebElement cartButton = driver.findElement(cartButtonSelector);
        cartButton.click();
        System.out.println("Opened cart.");
    }

    /**
     * Proceeds to checkout.
     */
    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(proceedToCheckoutButtonSelector);
        checkoutButton.click();
        System.out.println("Proceeded to checkout.");
    }

    /**
     * Adjusts the quantity of the product in the basket.
     */
    public void adjustQuantityInBasket() {
        // Increase quantity
        WebElement plusButton = driver.findElement(plusButtonSelector);
        plusButton.click();
        System.out.println("Increased quantity by 1.");

        // Timer between adjustments
        waitFor(1000, "Waited 2 seconds after increasing quantity.");

        // Decrease quantity
        WebElement minusButton = driver.findElement(minusButtonSelector);
        minusButton.click();
        System.out.println("Reduced quantity by 1.");

        // Timer between adjustments
        waitFor(1000, "Waited 2 seconds after reducing quantity.");
    }

    /**
     * Helper to simulate waiting for user actions.
     */
    private void waitFor(int milliseconds, String message) {
        try {
            Thread.sleep(milliseconds);
            System.out.println(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted during wait.");
        }
    }

}
