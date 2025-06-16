package info.seleniumcucumber.steps;

import info.seleniumcucumber.pages.AbstractPage;
import info.seleniumcucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import org.junit.Assert;

// Step definitions class for Cucumber scenarios related to login functionality
// Extends AbstractPage to inherit WebDriver and wait utilities
public class LoginSteps extends AbstractPage {

    // Cucumber step definition for: "Given I should get logged-in"
    @Given("^I should get logged-in$")
    public void should_logged_in() throws NoSuchFieldException {
        // Create a new instance of LoginPage (Page Object)
        final LoginPage loginPage = new LoginPage();

        // Get the message element text and check if it contains expected login success message
        // loginPage.getMessage() waits for the message element to load, then returns it
        String actualMessage = loginPage.getMessage().getText().split("\n")[0].trim();

        // Assertion to validate that the login was successful
        Assert.assertEquals("You logged into a secure area!", actualMessage);
    }
}
