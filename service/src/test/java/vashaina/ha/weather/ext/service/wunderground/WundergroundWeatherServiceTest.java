package vashaina.ha.weather.ext.service.wunderground;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import vashaina.ha.weather.ext.domain.Forecast;
import vashaina.ha.weather.ext.domain.ZipCode;
import vashaina.ha.weather.ext.test.BaseIntegrationTest;
import vashaina.ha.weather.ext.test.TestUtils;

/**
 * Test the {@link WundergroundWeatherService} class.
 */
public class WundergroundWeatherServiceTest extends BaseIntegrationTest {

    @Autowired
    private WundergroundWeatherService service;

    private String response;

    @Before
    public void loadResponse() throws IOException {
        response = TestUtils.readFileFromClasspath("/data/wunderground/responses/forecast/98070.json");
        assertNotNull(response);
        assertFalse(response.isEmpty());

    }

    @Test
    public void testDependencyInjection() {
        assertNotNull(service);
    }

    @Test
    public void test98070() throws Exception {
        String url = "http://api.wunderground.com/api/0b50d6f48b0d3720/forecast/q/98070.json";
        TestUtils.mockRestTemplateJsonResponse(service.getRestTemplate(), url, response);
        String expectedForecast = "Mostly cloudy skies. A stray shower or thunderstorm is possible. Low 56F. Winds light and variable.";
        Forecast forecast = service.getForecast(new ZipCode("98070"));
        assertEquals(expectedForecast, forecast.getTomorrowsForecast());
    }

}
