package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {
    private WebDriver wd;

    public MainPage(WebDriver wd) {
        this.wd = wd;
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
