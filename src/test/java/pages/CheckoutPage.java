package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Page Object for the checkout process.
 */
public class CheckoutPage {
    private final WebDriver driver;

    // Selectors
    private final By contactEmailSelector = By.cssSelector("#checkoutform > div:nth-child(4) > input");
    private final By contactLastNameSelector = By.cssSelector("#checkoutform > div:nth-child(5) > input");
    private final By contactFirstNameSelector = By.cssSelector("#checkoutform > div:nth-child(6) > input");
    private final By contactPhoneSelector = By.cssSelector("#checkoutform > div:nth-child(7) > input");
    private final By countyDropdownSelector = By.cssSelector("#_shippingRegion");
    private final By cityDropdownSelector = By.cssSelector("#_shippingCity");
    private final By deliveryAddressSelector = By.cssSelector("#_shippingAddressHolder > input.input-s.col-sm-5.col-xs-8.-g-storage");
    private final By agreePolicyCheckboxSelector = By.cssSelector("#checkoutform > div.label-s.col-xs-12.custom-chk > label > div > input");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Fills out contact information in the checkout form.
     */
    public void fillContactInformation(String email, String lastName, String firstName, String phone) {
        driver.findElement(contactEmailSelector).sendKeys(email);
        driver.findElement(contactLastNameSelector).sendKeys(lastName);
        driver.findElement(contactFirstNameSelector).sendKeys(firstName);
        driver.findElement(contactPhoneSelector).sendKeys(phone);
    }

    /**
     * Fills out delivery information in the checkout form.
     */
    public void fillDeliveryInformation(String county, String city, String address) {
        new Select(driver.findElement(countyDropdownSelector)).selectByVisibleText(county);
        new Select(driver.findElement(cityDropdownSelector)).selectByVisibleText(city);
        driver.findElement(deliveryAddressSelector).sendKeys(address);
    }

    /**
     * Agrees to the policy.
     */
    public void agreeToPolicy() {
        driver.findElement(agreePolicyCheckboxSelector).click();
    }
}
