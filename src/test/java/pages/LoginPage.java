package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By errorMessageSelector = By.cssSelector("#register-page > div > div.old-client-section.col-sm-5.pull-right > div > div.register-form > form > div.errorMsg");

    public LoginPage(WebDriver driver) { this.driver = driver;}

    public void goTo() {
        driver.get("https://www.pmstore.ro/");
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("li.-g-user-icon > a > span")).click();
    }

    public void fillLoginForm(String loginEmail, String loginPassword) {
        driver.findElement(By.cssSelector("#_loginEmail")).sendKeys(loginEmail);
        driver.findElement(By.cssSelector("#_loginPassword")).sendKeys(loginPassword);
    }
    public boolean isErrorMessageDisplayed() {
        return !driver.findElements(errorMessageSelector).isEmpty();
    }

    public void clickLogin_Button() {
        driver.findElement(By.cssSelector("#doLogin")).click();
    }





}
