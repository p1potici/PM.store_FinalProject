package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.webUtils;


class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    @BeforeEach
    void setup() {
        driver = webUtils.getWebDriver();
        loginPage = new LoginPage(driver);
    }
    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#validLoginData")
    void testValidLogin(String loginEmail, String loginPassword) {
        loginPage.goTo();
        loginPage.clickLoginButton();
        loginPage.fillLoginForm(loginEmail, loginPassword);
        loginPage.clickLogin_Button();
    }
    @ParameterizedTest
    @MethodSource("data.LoginDataProvider#invalidLoginData")
    void testInvalidLogin(String loginEmail, String loginPassword) {
            loginPage.goTo();
            loginPage.clickLoginButton();
            loginPage.fillLoginForm(loginEmail, loginPassword);
            loginPage.clickLogin_Button();

        // Check if error message is shown
        boolean isErrorMessageDisplayed;
        if (driver.findElements(By.cssSelector("#register-page > div > div.old-client-section.col-sm-5.pull-right > div > div.register-form > form > div.errorMsg")).size() > 0)
            isErrorMessageDisplayed = true;
        else isErrorMessageDisplayed = false;
        Assertions.assertTrue(isErrorMessageDisplayed, "Adresa de e-mail / parola introduse sunt incorecte. Te rugam sa incerci din nou.");

    }
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}