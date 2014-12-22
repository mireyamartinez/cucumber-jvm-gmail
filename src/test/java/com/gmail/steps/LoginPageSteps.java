package com.gmail.steps;

import com.gmail.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class LoginPageSteps {
    private LoginPage loginPage;

    public LoginPageSteps() {
        loginPage = new LoginPage();
    }

    @Given("^I am on Gmail homepage$")
    public void I_am_on_Gmail_homepage() throws Throwable {
        loginPage.goToURL();
    }

    @When("^I enter incorrect login credentials$")
    public void I_enter_incorrect_login_credentials() throws Throwable {
        loginPage.enterInvalidCredentials();
    }

    @Then("^I should see message for incorrect credentials$")
    public void I_should_see_message_for_incorrect_credentials() throws Throwable {
        assertEquals("Message for incorrect email/password did not appear", "the email or password you entered is incorrect. ?".toLowerCase(), loginPage.getMessageText("invalidCredentials").toLowerCase());
    }

    @When("^I leave \"([^\"]*)\" blank and continue$")
    public void I_leave_blank_and_continue(String credential) throws Throwable {
        loginPage.leaveCredentialBlank(credential);
    }


    @Then("^I should see message to enter email address$")
    public void I_should_see_mesage_to_enter_email_address() throws Throwable {
        assertEquals("Message to enter email address did not appear", "Enter your email address.".toLowerCase(), loginPage.getMessageText("enterEmail").toLowerCase());
    }

    @Then("^I should see message enter  password$")
    public void I_should_see_mesage_enter_password() throws Throwable {
        assertEquals("Message to enter password did not appear", "Enter your password.".toLowerCase(), loginPage.getMessageText("enterPassword").toLowerCase());
    }
}
