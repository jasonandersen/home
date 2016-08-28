package vashaina.ha.weather.ext.cucumber;

import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Step definitions for ext-weather service specification tests.
 */
public class ExtWeatherServiceSpecificationSteps extends BaseCucumberSteps {

    @Given("^this stubbed response:$")
    public void thisStubbedResponse(Map<String, String> attributes) throws Throwable {
        /*
         * 
         */
    }

    @When("^this request is received:$")
    public void thisRequestIsReceived(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }

    @Then("^a \"([^\"]*)\" status code is returned$")
    public void aStatusCodeIsReturned(int code) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^this response body is returned:$")
    public void thisResponseBodyIsReturned(String response) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    /**
     * @see vashaina.ha.weather.ext.cucumber.BaseCucumberSteps#tearDown()
     */
    @After
    @Override
    public void tearDown() {
        super.tearDownTestContext();
    }

}
