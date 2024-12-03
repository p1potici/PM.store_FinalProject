package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.ProductPage;
import utils.webUtils;

import static org.junit.jupiter.api.Assertions.*;

class HoverMenuTest {
    private WebDriver driver;
    private ProductPage productPage;

    @BeforeEach
    void setup() {
        driver = webUtils.getWebDriver();
        productPage = new ProductPage(driver);
    }

    @Test
    void testHoverMenu() {
        // Navigate to the page with the hovering menu
        productPage.goTo("https://www.pmstore.ro/");

        // Locate the menu element (e.g., the button to hover over)
        WebElement menuButton = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > a"));

        // Hover over the menu button
        Actions actions = new Actions(driver);
        actions.moveToElement(menuButton).perform();

        // Wait for the dropdown to appear (you may need to adjust the wait time)
        WebElement dropdownMenu = driver.findElement(By.cssSelector("#main-menu > div > ul > li.all-product-button.menu-drop > div > ul"));
        assertTrue(dropdownMenu.isDisplayed(), "The menu should be visible after hover.");


        // Move the mouse away and verify the menu collapses (if applicable)
        actions.moveByOffset(0, 0).perform();
        assertFalse(dropdownMenu.isDisplayed(), "The menu should collapse after mouse leaves.");

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
