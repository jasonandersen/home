package vashaina.ha.weather.ext.driver;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import vashaina.ha.weather.ext.test.TestUtils;

/**
 * Just testing we got the regex right in {@link Response}.
 */
public class ResponseTest {

    private String json;
    private Response response;

    @Before
    public void setup() throws IOException {
        json = TestUtils.readFileFromClasspath("/data/ext-weather/text-forecast/success-response.json");
        response = new Response(json, 200);
    }

    @Test
    public void testTodaysForecast() {
        assertEquals("TODAYS_FORECAST", response.getTodaysForecast());
    }

    @Test
    public void testTomorrowsForecast() {
        assertEquals("TOMORROWS_FORECAST", response.getTomorrowsForecast());
    }

    @Test
    public void testGetSource() {
        assertEquals("Wunderground.com", response.getSource());
    }

    @Test
    public void testGetZip() {
        assertEquals("98070", response.getZip());
    }

}
