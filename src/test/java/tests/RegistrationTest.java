package tests;

import pages.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
        registrationPage.fillRegistrationForm(email, lastName, firstName, password, confirmPassword);
        registrationPage.acceptTermsAndConditions();
        registrationPage.submitRegistration();

        System.out.println("Test completed: Valid registration.");
    }

    @ParameterizedTest
    @MethodSource("data.RegistrationDataProvider#invalidRegistrationData")
    void testInvalidRegistration(String email, String lastName, String firstName, String password, String confirmPassword) {

        registrationPage.goTo();
        registrationPage.clickLoginButton();
        registrationPage.clickRegisterButton();
        registrationPage.fillRegistrationForm(email, lastName, firstName, password, confirmPassword);
        registrationPage.submitRegistration();

        System.out.println("Test completed: Invalid registration.");

    }
}