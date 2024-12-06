package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.LoginPage;

class E2E_AccountInfo_Test extends BaseTest {
    private LoginPage loginPage;
    private AccountPage accountPage;

    @BeforeEach
    void testSetup() {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    void testEditAccountInformation() {
        // Navigate to the homepage
        loginPage.goTo();
        System.out.println("Navigated to the homepage.");

        // Go to the login page
        loginPage.clickLoginButton();
        System.out.println("Navigated to the login page.");

        // Log in with valid credentials
        loginPage.fillLoginForm("John.Doee@example.com", "Test123!");
        loginPage.clickLogin_Button();
        System.out.println("Successfully logged in.");

        // Step 4: Edit account information
        accountPage.clickEditButton();
        System.out.println("Opened account edit form.");

        accountPage.updateName("Bratislava");
        System.out.println("Bratislava");

        accountPage.clickSaveButton();
        System.out.println("Saved account information changes successfully.");
        System.out.println("acc. edited sucessfully.");
    }
}
