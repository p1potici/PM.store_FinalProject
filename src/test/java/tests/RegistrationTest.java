package tests;

import pages.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Tests for validating registration functionality.
 */
class RegistrationTest extends BaseTest {
    private RegistrationPage registrationPage;

    @BeforeEach
    void testSetup() {
        registrationPage = new RegistrationPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.RegistrationDataProvider#validRegistrationData")
    void testValidRegistration(String email, String lastName, String firstName, String password, String confirmPassword) {
        // Step 1: Navigate to homepage
        registrationPage.goTo();

        // Step 2: Open registration form via login button
        registrationPage.clickLoginButton();
        registrationPage.clickRegisterButton();

        // Step 3: Fill registration form with valid details
        registrationPage.fillRegistrationForm(email, lastName, firstName, password, confirmPassword);

        // Step 4: Accept terms and conditions
        registrationPage.acceptTermsAndConditions();

        // Step 5: Submit registration form
        registrationPage.submitRegistration();

        System.out.println("Test completed: Valid registration.");
    }

    @ParameterizedTest
    @MethodSource("data.RegistrationDataProvider#invalidRegistrationData")
    void testInvalidRegistration(String email, String lastName, String firstName, String password, String confirmPassword) {
        // Step 1: Navigate to homepage
        registrationPage.goTo();

        // Step 2: Open registration form via login button
        registrationPage.clickLoginButton();
        registrationPage.clickRegisterButton();

        // Step 3: Fill registration form with invalid details
        registrationPage.fillRegistrationForm(email, lastName, firstName, password, confirmPassword);

        // Step 4: Submit registration form
        registrationPage.submitRegistration();

        System.out.println("Test completed: Invalid registration.");
    }
}