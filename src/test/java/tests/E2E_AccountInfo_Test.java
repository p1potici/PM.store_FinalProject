package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;


class E2E_AccountInfo_Test extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
    }

    @Test
    void testEditAccountInformation() {
        // Step 1: Navigate to the homepage
        loginPage.goTo();
        System.out.println("Navigated to the homepage.");

        // Step 2: Go to the login page
        WebElement loginButton = driver.findElement(By.cssSelector("li.-g-user-icon > a > span"));
        loginButton.click();
        System.out.println("Navigated to the login page.");

        // Step 3: Log in with valid credentials
        WebElement emailField = driver.findElement(By.cssSelector("#_loginEmail"));
        emailField.sendKeys("John.Doee@example.com");

        WebElement passwordField = driver.findElement(By.cssSelector("#_loginPassword"));
        passwordField.sendKeys("Test123!");

        WebElement submitLogin = driver.findElement(By.cssSelector("#doLogin"));
        submitLogin.click();
        System.out.println("Successfully logged in.");

        // Step 5: Edit account information
        WebElement editButton = driver.findElement(By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.side-menu.col-lg-3.col-md-3.col-sm-12.col-xs-12 > div.row > ul:nth-child(4) > li:nth-child(2) > a"));
        editButton.click();
        System.out.println("Opened account edit form.");

        WebElement nameField = driver.findElement(By.cssSelector("#wrapper > div.account-h.container-h.container-bg > div > div.account-section.clearfix.col-sm-12.col-xs-12.col-lg-9.col-md-9 > form > div:nth-child(2) > input"));
        nameField.clear();
        String newName = "New Name";
        nameField.sendKeys(newName);

        WebElement saveButton = driver.findElement(By.cssSelector("#doSave"));
        saveButton.click();
        System.out.println("Saved account information changes.");


    }
}
