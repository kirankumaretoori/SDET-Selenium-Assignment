package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pages.OrangePages;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
public class StepDefinition {
	WebDriver driver;
	OrangePages op;

    @Given("^When I am in OrangeHRP Application $")
    public void when_i_am_in_orangehrp_application() throws Throwable {
        throw new PendingException();
    }

    @When("^Dashboard page is available $")
    public void dashboard_page_is_available() throws Throwable {
        throw new PendingException();
    }

    @Then("^Login to Application $")
    public void login_to_application() throws Throwable {
        throw new PendingException();
    }

    @And("^ click on Admin menu$")
    public void click_on_admin_menu() throws Throwable {
        throw new PendingException();
    }

}