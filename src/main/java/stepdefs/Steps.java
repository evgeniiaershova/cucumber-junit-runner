package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import sun.rmi.runtime.Log;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

public class Steps {

    WebDriver wd;

    public Steps() {
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
    }



    @Given("^I open url: \"([^\"]*)\"$")
    public void i_open_url(String url) throws Exception {
        wd.get(url);

    }

    @When("^I click on Log in button$")
    public void i_click_on_Log_in_button() throws Exception {
        MainPage mainPage = new MainPage(wd);
        mainPage.clickLogin();
    }

    @When("^I enter not existing login")
    public void i_enter_not_existing_login(){
       LoginPage loginPage = new LoginPage(wd);
       loginPage.enterLogin("tratatata@fdslf.com");
    }

    @When("^I enter wrong password$")
    public void i_enter_wrong_password() {
        LoginPage loginPage = new LoginPage(wd);
        loginPage.enterPassword("tratatata");
    }

    @When("^I submit form$")
    public void i_submit_form(){
        LoginPage loginPage = new LoginPage(wd);
        loginPage.submitLogin();
    }

    @Then("^I check I am on login page$")
    public void i_check_I_am_on_login_page(){
        LoginPage loginPage = new LoginPage(wd);
        Assert.assertThat("Redirect to login page failed", wd.getCurrentUrl(), equalTo(loginPage.getUrl()));
        assertTrue("Email input is not displayed", loginPage.emailInput.isDisplayed());
    }

    @Then("^I see \"([^\"]*)\" message$")
    public void i_see_message(String arg1){
        LoginPage loginPage = new LoginPage(wd);
        assertTrue("Error message is not displayed", loginPage.errorMessageIsPresent());

    }

}
