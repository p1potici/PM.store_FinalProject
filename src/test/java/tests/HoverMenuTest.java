package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.ProductPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for verifying hover functionality on the main menu.
 */
class HoverMenuTest extends BaseTest {
    private ProductPage productPage;

    @BeforeEach
    void testSetup() {
        productPage = new ProductPage(driver);
    }

    @Test
    void testHoverMenu() {
        // Step 1: Navigate to the homepage
        productPage.goTo("https://www.pmstore.ro/");
        System.out.println("Navigated to the homepage.");

        // Step 2: Locate the menu element to hover over
        WebElement menuButton = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > a"));
        System.out.println("Located the menu button for hovering.");

        // Step 3: Hover over the menu button
        Actions actions = new Actions(driver);
        actions.moveToElement(menuButton).perform();
        System.out.println("Hovered over the menu button.");

        // Step 4: Wait for the dropdown menu to appear and verify its visibility
        WebElement dropdownMenu = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > div > ul"));
        boolean isDropdownDisplayed = dropdownMenu.isDisplayed();
        assertTrue(isDropdownDisplayed, "The dropdown menu should be visible after hovering.");
        System.out.println("Dropdown menu is visible after hover.");

        // Step 5: Move the mouse away to collapse the dropdown menu (if applicable)
        actions.moveByOffset(0, 0).perform(); // Move the mouse away
        System.out.println("Moved the mouse away from the dropdown menu.");

        // Step 6: Verify the dropdown menu collapses
        try {
            Thread.sleep(1000); // Short wait for the menu to collapse
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isDropdownCollapsed = !dropdownMenu.isDisplayed();
        assertTrue(isDropdownCollapsed, "The dropdown menu should collapse after the mouse leaves.");
        System.out.println("Dropdown menu collapsed after mouse left.");
    }
}
