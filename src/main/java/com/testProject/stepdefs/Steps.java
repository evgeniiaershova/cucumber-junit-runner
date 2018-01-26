package com.testProject.stepdefs;

import com.testProject.configuration.AppConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.testProject.pageobjects.LoginPage;
import com.testProject.pageobjects.MainPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class Steps {

    @Autowired
    WebDriver wd;
    @Autowired
    LoginPage loginPage;
    @Autowired
    MainPage mainPage;

    @Given("^I open url: \"([^\"]*)\"$")
    public void i_open_url(String url) throws Exception {
        wd.get(url);
    }

    @When("^I click on Log in button$")
    public void i_click_on_Log_in_button() throws Exception {
        mainPage.clickLogin();
    }

    @When("^I enter not existing login")
    public void i_enter_not_existing_login(){
       loginPage.enterLogin("tratatata@fdslf.com");
    }

    @When("^I enter wrong password$")
    public void i_enter_wrong_password() {
        loginPage.enterPassword("tratatata");
    }

    @When("^I submit form$")
    public void i_submit_form(){
        loginPage.submitLogin();
    }

    @Then("^I check I am on login page$")
    public void i_check_I_am_on_login_page(){
        Assert.assertThat("Redirect to login page failed", wd.getCurrentUrl(), equalTo(loginPage.getUrl()));
        assertTrue("Email input is not displayed", loginPage.emailInput.isDisplayed());
    }

    @Then("^I see \"([^\"]*)\" message$")
    public void i_see_message(String arg1){
        assertTrue("Error message is not displayed", loginPage.errorMessageIsPresent());
    }

}
