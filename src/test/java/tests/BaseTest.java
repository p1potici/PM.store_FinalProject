package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.webUtils;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setup() {
        driver = webUtils.getWebDriver(); // WebDriver
        System.out.println("WebDriver initialized.");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit(); // Quits WebDriver
            System.out.println("WebDriver closed.");
        }
    }
}
