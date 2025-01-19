package org.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DemoProjectSteps extends CommonSteps {

    public DemoProjectSteps() throws Exception {
    }


    @Given("I have a demo project")
    public void iHaveADemoProject() {
        openURL();
    }


    @When("I run the demo project")
    public void iRunTheDemoProject() {
        loginToApplication();
    }


    @Then("I should see the demo project running")
    public void iShouldSeeTheDemoProjectRunning() {
    }


    @Given("I am on google search page")
    public void iAmOnGoogleSearchPage() {
        openURL();
    }


    @When("I search for {string}")
    public void iSearchFor(String searchText) {
        searchOnGoogle(searchText);
    }


    @Then("I should see {string} as the top result")
    public void iShouldSeeAsTheTopResult(String expectedText) {
        verifyTopResult(expectedText);
    }
}
