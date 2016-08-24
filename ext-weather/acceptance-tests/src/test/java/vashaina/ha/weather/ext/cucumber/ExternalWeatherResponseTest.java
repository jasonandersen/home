package vashaina.ha.weather.ext.cucumber;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Just testing we got the regex right in {@link ExternalWeatherResponse}.
 */
public class ExternalWeatherResponseTest {

    private String json = "{\"todaysForecast\":\"TODAYS_FORECAST\",\"tomorrowsForecast\":\"TOMORROWS_FORECAST\"}";
    private ExternalWeatherResponse response;

    @Before
    public void setup() {
        response = new ExternalWeatherResponse(json, 200);
    }

    @Test
    public void testTodaysForecast() {
        assertEquals("TODAYS_FORECAST", response.getTodaysForecast());
    }

    @Test
    public void testTomorrowsForecast() {
        assertEquals("TOMORROWS_FORECAST", response.getTomorrowsForecast());
    }

}
