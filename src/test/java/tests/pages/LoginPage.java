package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public By errorMessageFieldLocator = By.cssSelector("[data-test='error']");
    public By loginButtonLocator = By.cssSelector("[name='login-button']");
    public By passwordInputLocator = By.cssSelector("[data-test='password']");
    public By userNameInputLocator = By.cssSelector("[data-test='username']");
    public By logoFieldLocator = By.cssSelector(".login_logo");

    public void fillLoginFrom(Map<String, String> loginData) {
        if (loginData.containsKey("userName")) {
            $(userNameInputLocator).sendKeys(Keys.CONTROL + "A");
            $(userNameInputLocator).sendKeys(Keys.BACK_SPACE);
            $(userNameInputLocator).sendKeys(loginData.get("userName"));
        }
        if (loginData.containsKey("password")) {
            $(passwordInputLocator).sendKeys(Keys.CONTROL + "A");
            $(passwordInputLocator).sendKeys(Keys.BACK_SPACE);
            $(passwordInputLocator).sendKeys(loginData.get("password"));
        }
    }
}
