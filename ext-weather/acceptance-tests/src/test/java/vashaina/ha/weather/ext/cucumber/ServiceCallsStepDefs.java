package vashaina.ha.weather.ext.cucumber;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Step definitions to call the ha-ext-weather-ws web service.
 */
public class ServiceCallsStepDefs extends BaseCucumberSteps {

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
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I get an \"([^\"]*)\" error$")
    public void iGetAnError(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the error message is \"([^\"]*)\"$")
    public void theErrorMessageIs(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
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
        WundergroundStub stub = new WundergroundStub();
        stub.setTodaysForecast(get(KEY_WG_FORECAST_TODAY));
        stub.setTonightsForecast(get(KEY_WG_FORECAST_TONIGHT));
        stub.setTomorrowsForecast(get(KEY_WG_FORECAST_TOMORROW));
        stub.setTomorrowNightsForecast(get(KEY_WG_FORECAST_TOMORROW_NIGHT));
        ExternalWeatherRequest request = new ExternalWeatherRequest();
        request.setZipCode(get(KEY_REQUEST_ZIP));
        request.setWundergroundStub(stub);
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * @return the forecast for today returned by the service
     */
    private String getActualTodaysForecast() {
        //TODO implement
        return null;
    }

    /**
     * @return the forecast for tomorrow returned by the service
     */
    private String getActualTomorrowsForecast() {
        //TODO implement
        return null;
    }

    /**
     * @return the source of the forecast returned by the service
     */
    private String getActualSource() {
        //TODO implement
        return null;
    }

    /**
     * @return the zip code of the forecast request returned by the service
     */
    private String getActualZip() {
        //TODO implement
        return null;
    }

}
