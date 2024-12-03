package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

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

    public void clickLogin_Button() {
        driver.findElement(By.cssSelector("#doLogin")).click();
    }



}
