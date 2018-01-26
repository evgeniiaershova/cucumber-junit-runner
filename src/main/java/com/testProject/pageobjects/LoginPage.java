package com.testProject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class LoginPage extends Page{

    @Autowired
    private WebDriver wd;

    @PostConstruct
    public void initLoginPage() {
        PageFactory.initElements(wd, this);
    }

    public String getUrl() {
        return "https://moz.com/login";
    }

    @FindBy(name = "data[User][login_email]")
    public WebElement emailInput;

    @FindBy(name = "data[User][password]")
    private WebElement passwordInput;

    @FindBy(xpath = "//button")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[contains(.,'Invalid email or password')]")
    private WebElement errorMessage;

    public boolean errorMessageIsPresent() {
        return errorMessage.isDisplayed();
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterLogin(String login) {
        emailInput.sendKeys(login);
    }

    public void submitLogin() {
        new WebDriverWait(wd, 5).until(ExpectedConditions.visibilityOf(loginBtn)).click();
    }
}
