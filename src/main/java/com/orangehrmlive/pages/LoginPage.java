package com.orangehrmlive.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    protected final String LOGIN_URL = BASE_URL;
    protected final String INVALID_CREDENTIALS_MESSAGE = "Invalid Credentials";

    // Web elements
    @FindBy(xpath = "//input[@id='txtUsername']") protected WebElement usernameInputField;
    @FindBy(xpath = "//input[@id='txtPassword']") protected WebElement passwordInputField;
    @FindBy(xpath = "//button[@type='submit']") protected WebElement loginButtonElement;
    @FindBy(xpath = "//div[@class='toast-message']") protected WebElement toastMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterCredentialsAndLogin(String username, String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        clickLoginButton();
    }

    public void clickLoginButton() {
        loginButtonElement.click();
    }

    public void navigateToLoginPage() {
        driver.get(LOGIN_URL);
    }

    public String getToastMessage() {
        return toastMessage.getText();
    }

    public String getExpectedErrorMessage() {
        return INVALID_CREDENTIALS_MESSAGE;
    }
}
