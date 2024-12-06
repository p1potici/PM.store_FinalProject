package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
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
        System.out.println("Navigated to homepage.");

        // Step 2: Click login button
        loginPage.clickLoginButton();
        System.out.println("Clicked login button.");

        // Step 3: Fill login form with valid credentials
        loginPage.fillLoginForm(loginEmail, loginPassword);
        System.out.println("Filled login form with valid credentials.");

        // Step 4: Submit login form
        loginPage.clickLogin_Button();
        System.out.println("Submitted login form.");

        System.out.println("Test completed: Valid login.");
    }

    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#invalidLoginData")
    void testInvalidLogin(String loginEmail, String loginPassword) {
        // Step 1: Navigate to homepage
        loginPage.goTo();
        System.out.println("Navigated to homepage.");

        // Step 2: Click login button
        loginPage.clickLoginButton();
        System.out.println("Clicked login button.");

        // Step 3: Fill login form with invalid credentials
        loginPage.fillLoginForm(loginEmail, loginPassword);
        System.out.println("Filled login form with invalid credentials.");

        // Step 4: Submit login form
        loginPage.clickLogin_Button();
        System.out.println("Submitted login form.");

        // Step 5: Verify error message is displayed
        boolean isErrorMessageDisplayed = loginPage.isErrorMessageDisplayed();
        Assertions.assertTrue(isErrorMessageDisplayed, "");
        System.out.println("Verified error message for invalid login.");

        System.out.println("Test completed: Invalid login.");
    }
}

