package com.testProject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MainPage extends Page {

    @Autowired
    private WebDriver wd;

    @PostConstruct
    public void initMainPage() {
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//a[@href='https://moz.com/login']")
    private WebElement loginBtn;

    public void clickLogin() {
        loginBtn.click();
    }

    public String getUrl() {
        return "https://moz.com/";
    }
}
