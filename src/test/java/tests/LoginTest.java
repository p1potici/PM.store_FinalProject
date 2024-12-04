package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.junit.jupiter.api.*;
import pages.LoginPage;

/**
 * Tests for validating login functionality.
 */
class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    void testValidLogin(String loginEmail, String loginPassword) {
        // Step 1: Navigate to homepage
        loginPage.goTo();

        // Step 2: Click login button
        loginPage.clickLoginButton();

        // Step 3: Fill login form with valid credentials
        loginPage.fillLoginForm(loginEmail, loginPassword);

        // Step 4: Submit login form
        loginPage.clickLogin_Button();

        System.out.println("Test completed: Valid login.");
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#invalidLoginData")
    void testInvalidLogin(String loginEmail, String loginPassword) {
        // Step 1: Navigate to homepage
        loginPage.goTo();

        // Step 2: Click login button
        loginPage.clickLoginButton();

        // Step 3: Fill login form with invalid credentials
        loginPage.fillLoginForm(loginEmail, loginPassword);

        // Step 4: Submit login form
        loginPage.clickLogin_Button();

        // Step 5: Verify error message is displayed
        boolean isErrorMessageDisplayed = driver.findElements(By.cssSelector("#register-page > div > div.old-client-section.col-sm-5.pull-right > div > div.register-form > form > div.errorMsg")).size() > 0;
        Assertions.assertTrue(isErrorMessageDisplayed, "Adresa de e-mail / parola introduse sunt incorecte. Te rugam sa incerci din nou.");

        System.out.println("Test completed: Invalid login.");
    }
}
