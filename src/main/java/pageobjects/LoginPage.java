package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page{
    private WebDriver wd;

    public LoginPage(WebDriver wd) {
        this.wd = wd;
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
