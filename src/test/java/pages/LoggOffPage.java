package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for handling user logoff functionality.
 */
public class LoggOffPage {
    private final WebDriver driver;

    // Selectors
    private final By accountMenuSelector = By.cssSelector("#wrapper > header > div > div > div > div.col-sm-6.col-xs-12.cart-menu > ul > li.-g-user-icon.-g-user-loggedin-icon > a > span");
    private final By logoutButtonSelector = By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul:nth-child(5) > li > a");

    // Constructor
    public LoggOffPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    /**
     * Logs off the user by navigating through the account menu.
     */
    public void logOff() {
        // Open the account menu
        driver.findElement(accountMenuSelector).click();
        System.out.println("Opened account menu.");

        // Click the logout button
        driver.findElement(logoutButtonSelector).click();
        System.out.println("Logged off successfully.");
    }
}
