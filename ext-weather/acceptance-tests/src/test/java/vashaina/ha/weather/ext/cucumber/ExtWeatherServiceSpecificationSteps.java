package vashaina.ha.weather.ext.cucumber;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import vashaina.ha.weather.ext.test.TestUtils;
import vashaina.ha.weather.ext.wunderground.SimpleStub;
import vashaina.ha.weather.ext.wunderground.WundergroundStub;

/**
 * Step definitions for ext-weather service specification tests.
 */
public class ExtWeatherServiceSpecificationSteps extends BaseCucumberSteps {

    @Autowired
    private ExternalWeatherGateway gateway;

    @Given("^this stubbed response:$")
    public void thisStubbedResponse(Map<String, String> attributes) throws Throwable {
        String url = attributes.get("url");
        String response = TestUtils.readFileFromClasspath(attributes.get("response"));
        WundergroundStub stub = new SimpleStub(url, response);
        put(KEY_WG_STUB, stub);
    }

    @When("^this request is received:$")
    public void thisRequestIsReceived(Map<String, String> attributes) throws Throwable {
        String path = attributes.get("path");
        WundergroundStub stub = get(KEY_WG_STUB);
        ExternalWeatherResponse response = gateway.executeFromPath(path, stub);
        put(KEY_SUT_RESPONSE, response);
    }

    @Then("^a status code ([^\"]*) is returned$")
    public void aStatusCodeIsReturned(int code) throws Throwable {
        ExternalWeatherResponse response = get(KEY_SUT_RESPONSE);
        assertEquals(code, response.getStatusCode());
    }

    @Then("^this response body is returned:$")
    public void thisResponseBodyIsReturned(String expectedResponse) throws Throwable {
        ExternalWeatherResponse response = get(KEY_SUT_RESPONSE);
        assertEquals(expectedResponse, response.getResponseBody());
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
