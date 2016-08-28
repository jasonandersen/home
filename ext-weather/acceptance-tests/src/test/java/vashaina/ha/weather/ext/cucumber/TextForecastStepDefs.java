package vashaina.ha.weather.ext.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import vashaina.ha.weather.ext.wunderground.TemplatedStub;
import vashaina.ha.weather.ext.wunderground.WundergroundDouble;

/**
 * Step definitions to call the ha-ext-weather-ws web service.
 */
public class TextForecastStepDefs extends BaseCucumberSteps {

    @Autowired
    private ExternalWeatherGateway gateway;

    @SuppressWarnings("unused")
    @Given("^today is \"([^\"]*)\"$")
    public void todayIs(String today) throws Throwable {
        //NOOP - nothing is required for this, just a documenting step
    }

    @Given("^we are requesting a forecast for zip code (\\d+)$")
    public void weAreRequestingAForecastForZipCode(String zip) throws Throwable {
        put(KEY_REQUEST_ZIP, zip);
    }

    @Given("^the Wunderground forecast for today is \"([^\"]*)\"$")
    public void theWundergroundForecastForTodayIs(String todaysForecast) throws Throwable {
        put(KEY_WG_FORECAST_TODAY, todaysForecast);
    }

    @Given("^the Wunderground forecast for tonight is \"([^\"]*)\"$")
    public void theWundergroundForecastForTonightIs(String tonightsForecast) throws Throwable {
        put(KEY_WG_FORECAST_TONIGHT, tonightsForecast);
    }

    @Given("^the Wunderground forecast for tomorrow is \"([^\"]*)\"$")
    public void theWundergroundForecastForTomorrowIs(String tomorrowsForecast) throws Throwable {
        put(KEY_WG_FORECAST_TOMORROW, tomorrowsForecast);
    }

    @Given("^the Wunderground forecast for tomorrow night is \"([^\"]*)\"$")
    public void theWundergroundForecastForTomorrowNightIs(String tomorrowNightsForecast) throws Throwable {
        put(KEY_WG_FORECAST_TOMORROW_NIGHT, tomorrowNightsForecast);
    }

    @When("^I request a forecast for zip code \"([^\"]*)\"$")
    public void iRequestAForecastForZipCode(String zip) throws Throwable {
        weAreRequestingAForecastForZipCode(zip);
        submitRequest();
    }

    @Then("^the forecast for today is \"([^\"]*)\"$")
    public void theForecastForTodayIs(String expectedTodaysForecast) throws Throwable {
        String actualTodaysForecast = getActualTodaysForecast();
        assertEquals(expectedTodaysForecast, actualTodaysForecast);
    }

    @Then("^the forecast for tomorrow is \"([^\"]*)\"$")
    public void theForecastForTomorrowIs(String expectedTomorrowsForecast) throws Throwable {
        String actualTomorrowsForecast = getActualTomorrowsForecast();
        assertEquals(expectedTomorrowsForecast, actualTomorrowsForecast);
    }

    @Then("^the source is \"([^\"]*)\"$")
    public void theSourceIs(String expectedSource) throws Throwable {
        String actualSource = getActualSource();
        assertEquals(expectedSource, actualSource);
    }

    @Then("^the zip code is \"([^\"]*)\"$")
    public void theZipCodeIs(String expectedZip) throws Throwable {
        String actualZip = getActualZip();
        assertEquals(expectedZip, actualZip);
    }

    @Then("^there are no errors$")
    public void thereAreNoErrors() throws Throwable {
        fail("not implemented yet");
    }

    @Then("^I get an \"([^\"]*)\" error$")
    public void iGetAnError(String arg1) throws Throwable {
        fail("not implemented yet");
    }

    @Then("^the error message is \"([^\"]*)\"$")
    public void theErrorMessageIs(String arg1) throws Throwable {
        fail("not implemented yet");
    }

    /**
     * @see vashaina.ha.weather.ext.domain.BaseCucumberSteps#tearDown()
     */
    @After
    @Override
    public void tearDown() {
        super.tearDownTestContext();
    }

    /**
     * Submits request to the service.
     */
    private void submitRequest() {
        String zip = get(KEY_REQUEST_ZIP);
        WundergroundDouble stub = buildStub(zip);
        ExternalWeatherResponse response = gateway.execute(zip, stub);
        put(KEY_SUT_RESPONSE, response);
    }

    /**
     * @return the wunderground stubbed out call
     */
    private WundergroundDouble buildStub(String zip) {
        TemplatedStub stub = new TemplatedStub(zip);
        stub.setTodaysForecast((String) get(KEY_WG_FORECAST_TODAY));
        stub.setTonightsForecast((String) get(KEY_WG_FORECAST_TONIGHT));
        stub.setTomorrowsForecast((String) get(KEY_WG_FORECAST_TOMORROW));
        stub.setTomorrowNightsForecast((String) get(KEY_WG_FORECAST_TOMORROW_NIGHT));
        return stub;
    }

    /**
     * @return the forecast for today returned by the service
     */
    private String getActualTodaysForecast() {
        return getResponse().getTodaysForecast();
    }

    /**
     * @return the forecast for tomorrow returned by the service
     */
    private String getActualTomorrowsForecast() {
        return getResponse().getTomorrowsForecast();
    }

    /**
     * @return the source of the forecast returned by the service
     */
    private String getActualSource() {
        return null;
    }

    /**
     * @return the zip code of the forecast request returned by the service
     */
    private String getActualZip() {
        return null;
    }

    /**
     * @return the external weather service call response
     */
    private ExternalWeatherResponse getResponse() {
        return get(KEY_SUT_RESPONSE);
    }

}
