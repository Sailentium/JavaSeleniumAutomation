package tests.pages;

import org.openqa.selenium.By;

public class LoginPage {
    public By errorMessageFieldLocator = By.cssSelector("[data-test='error']");
    public By loginButtonLocator = By.cssSelector("[name='login-button']");
    public By passwordInputLocator = By.cssSelector("[data-test='password']");
    public By userNameInputLocator = By.cssSelector("[data-test='username']");
    public By logoFieldLocator = By.cssSelector(".login_logo");
}
