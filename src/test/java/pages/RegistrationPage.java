package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://www.pmstore.ro/");
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("li.-g-user-icon > a > span")).click();
    }

    public void clickRegisterButton() {
        driver.findElement(By.cssSelector("#_submitRegistration > div")).click();
    }

    public void fillRegistrationForm(String email, String lastName, String firstName, String password, String confirmPassword) {
        driver.findElement(By.cssSelector("#__emailRegister")).sendKeys(email);
        driver.findElement(By.cssSelector("#__lastnameRegister")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#__firstnameRegister")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#__passwordRegister")).sendKeys(password);
        driver.findElement(By.cssSelector("#__confirmPasswordRegister")).sendKeys(confirmPassword);
    }

    public void acceptTermsAndConditions() {
        WebElement agreementCheckbox = driver.findElement(By.cssSelector("#_submitRegistration > div > div > p:nth-child(7) > label > div > input"));
        if (!agreementCheckbox.isSelected()) {
            agreementCheckbox.click();
        }
    }

    public void submitRegistration() {
        driver.findElement(By.cssSelector("#doRegister")).click();
    }
}
