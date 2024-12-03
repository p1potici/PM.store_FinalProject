package tests;

import data.RegistrationDataProvider;
import pages.RegistrationPage;
import utils.webUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

class RegistrationTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeEach
    void setup() {
        driver = webUtils.getWebDriver();
        registrationPage = new RegistrationPage(driver);
    }

    @ParameterizedTest
    @MethodSource("data.RegistrationDataProvider#validRegistrationData")
    void testValidRegistration(String email, String lastName, String firstName, String password, String confirmPassword) {
        registrationPage.goTo();
        registrationPage.clickLoginButton();
        registrationPage.clickRegisterButton();
        registrationPage.fillRegistrationForm(email, lastName, firstName, password, confirmPassword);
        registrationPage.acceptTermsAndConditions();
        registrationPage.submitRegistration();
    }

    @ParameterizedTest
    @MethodSource("data.RegistrationDataProvider#invalidRegistrationData")
    void testInvalidRegistration(String email, String lastName, String firstName, String password, String confirmPassword) {
        registrationPage.goTo();
        registrationPage.clickLoginButton();
        registrationPage.clickRegisterButton();
        registrationPage.fillRegistrationForm(email, lastName, firstName, password, confirmPassword);
        registrationPage.submitRegistration();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}