package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * End-to-end test for completing the checkout process with form inputs.
 */
class E2E_CheckoutTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.CheckoutDataProvider#validCheckoutData")
    void testCheckoutProcess(String email, String lastName, String firstName, String phone, String county, String city, String address, String paymentMethod) {
        // Step 1: Navigate to the homepage
        loginPage.goTo();
        System.out.println("homepage.");

        // Step 2: Go to the login page
        WebElement loginButton = driver.findElement(By.cssSelector("li.-g-user-icon > a > span"));
        loginButton.click();
        System.out.println("login page.");

        // Step 3: Log in with valid credentials
        WebElement emailField = driver.findElement(By.cssSelector("#_loginEmail"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("#_loginPassword"));
        passwordField.sendKeys("Test123!");

        WebElement submitLogin = driver.findElement(By.cssSelector("#doLogin"));
        submitLogin.click();
        System.out.println("Successfully logged in.");

        // Step 4: Navigate to the product page using dropdown menu
        WebElement dropdownMenu = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > a"));
        dropdownMenu.click();
        WebElement dropdownLink = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > div > ul > li:nth-child(8) > a > span"));
        dropdownLink.click();
        System.out.println("Accessed the product page.");

        // Step 5: Add a product to the basket
        productPage.addToBasket();
        System.out.println("Added product to basket.");

        // Step 6: Open the basket
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productPage.openCart();
        System.out.println("Opened basket.");

        // Step 7: Proceed to checkout
        WebElement checkoutButton = driver.findElement(By.cssSelector("#shoppingcart > a.btn.btn-cmd.full.fr.-g-order-checkout-button"));
        checkoutButton.click();
        System.out.println("Proceeded to checkout.");

        // Step 8: Fill out the checkout form

        WebElement contactEmail = driver.findElement(By.cssSelector("#checkoutform > div:nth-child(4) > input"));
        contactEmail.sendKeys(email);

        WebElement contactLastName = driver.findElement(By.cssSelector("#checkoutform > div:nth-child(5) > input"));
        contactLastName.sendKeys(lastName);

        WebElement contactFirstName = driver.findElement(By.cssSelector("#checkoutform > div:nth-child(6) > input"));
        contactFirstName.sendKeys(firstName);

        WebElement contactPhone = driver.findElement(By.cssSelector("#checkoutform > div:nth-child(7) > input"));
        contactPhone.sendKeys(phone);

        // Delivery Information
        Select countyDropdown = new Select(driver.findElement(By.cssSelector("#_shippingRegion")));
        countyDropdown.selectByVisibleText(county);
        System.out.println("Selected county: " + county);

        Select cityDropdown = new Select(driver.findElement(By.cssSelector("#_shippingCity")));
        cityDropdown.selectByVisibleText(city);
        System.out.println("Selected city: " + city);

        WebElement deliveryAddress = driver.findElement(By.cssSelector("#_shippingAddressHolder > input.input-s.col-sm-5.col-xs-8.-g-storage"));
        deliveryAddress.sendKeys(address);

        // Agree to Policy
        WebElement agreePolicyCheckbox = driver.findElement(By.cssSelector("#checkoutform > div.label-s.col-xs-12.custom-chk > label > div > input"));
        agreePolicyCheckbox.click();
        System.out.println("Agreed to the policy.");
        System.out.println("Proceeeed?");

        // Step 7: Log off
        WebElement accountMenu = driver.findElement(By.cssSelector("#wrapper > header > div > div > div > div.col-sm-6.col-xs-12.cart-menu > ul > li.-g-user-icon.-g-user-loggedin-icon > a > span"));
        accountMenu.click();
        WebElement logoutButton = driver.findElement(By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul:nth-child(5) > li > a"));
        logoutButton.click();
        System.out.println("Logged off successfully.");

    }
}
