package vashaina.ha.weather.ext.service.wunderground;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import vashaina.ha.weather.ext.service.wunderground.response.Forecast;
import vashaina.ha.weather.ext.service.wunderground.response.ForecastDayText;
import vashaina.ha.weather.ext.service.wunderground.response.ForecastResponse;
import vashaina.ha.weather.ext.service.wunderground.response.Response;
import vashaina.ha.weather.ext.service.wunderground.response.TextForecast;

/**
 * Test the resiliency of the {@link WundergroundForecast} class.
 */
public class WundergroundForecastTest {

    private static final String URL = "http://host/path/to/api/call";

    private WundergroundForecast forecast;

    private ForecastResponse response;

    @Before
    public void setupResponse() {
        response = new ForecastResponse();

        //text forecast days
        ForecastDayText todaysForecast = new ForecastDayText();
        todaysForecast.setFcttext("today's forecast!");
        ForecastDayText tomorrowsForecast = new ForecastDayText();
        tomorrowsForecast.setFcttext("tomorrow's forecast!");

        List<ForecastDayText> forecastDays = new ArrayList<>();
        forecastDays.add(todaysForecast);
        forecastDays.add(tomorrowsForecast);

        //text forecast
        TextForecast textForecast = new TextForecast();
        textForecast.setForecastDays(forecastDays);

        //forecast
        Forecast frcast = new Forecast();
        frcast.setTxtForecast(textForecast);
        response.setForecast(frcast);

        //response
        Response resp = new Response();
        resp.setVersion("0.1");
        response.setResponse(resp);

        //setup test target
        forecast = new WundergroundForecast(response, URL);
    }

    /*
     * URL tests
     */
    @Test
    public void testUrlNotNull() {
        assertNotNull(forecast.getUrl());
        assertEquals(URL, forecast.getUrl());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUrlIsNull() {
        forecast = new WundergroundForecast(response, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUrlIsEmpty() {
        forecast = new WundergroundForecast(response, "");
    }

    /*
     * API Version tests
     */

    @Test
    public void testApiVersionHappyPath() {
        assertEquals("0.1", forecast.getApiVersion());
    }

    @Test
    public void testApiVersionNullForecastResponse() {
        forecast = new WundergroundForecast(null, URL);
        assertEquals("", forecast.getApiVersion());
    }

    @Test
    public void testToString() {
        assertEquals("WundergroundForecast:url=http://host/path/to/api/call;apiVersion=0.1", forecast.toString());
    }

    /*
     * Text forecast tests
     */

    @Test
    public void testTextForecastHappyPath() {
        assertTextForecast("today's forecast!", "tomorrow's forecast!");
    }

    @Test
    public void testTomorrowsForecastResponseIsNull() {
        forecast = new WundergroundForecast(null, URL);
        assertTextForecast("", "");
    }

    @Test
    public void testForecastIsNull() {
        response.setForecast(null);
        assertTextForecast("", "");
    }

    @Test
    public void testTextForecastIsNull() {
        response.getForecast().setTxtForecast(null);
        assertTextForecast("", "");
    }

    @Test
    public void testForecastDaysIsNull() {
        response.getForecast().getTxtForecast().setForecastDays(null);
        assertTextForecast("", "");
    }

    @Test
    public void testForecastDaysIsEmpty() {
        response.getForecast().getTxtForecast().getForecastDays().clear();
        assertTextForecast("", "");
    }

    @Test
    public void testForecastDaysOnlyOneEntry() {
        response.getForecast().getTxtForecast().getForecastDays().remove(1);
        assertTextForecast("today's forecast!", "");
    }

    @Test
    public void testForecastDayTextFcttextIsNull() {
        response.getForecast().getTxtForecast().getForecastDays().get(1).setFcttext(null);
        assertTextForecast("today's forecast!", "");
    }

    /**
     * Initialize the test target.
     */
    private void assertTextForecast(String today, String tomorrow) {
        assertEquals(today, forecast.getTodaysForecast());
        assertEquals(tomorrow, forecast.getTomorrowsTextForecast());
    }

}
