package vashaina.ha.weather.ext.cucumber;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import vashaina.ha.weather.ext.test.Template;

/**
 * Creates a stubbed response from Wunderground.com.
 */
public class WundergroundStub {

    private static final String FORECAST_TEMPLATE = "data/wunderground/forecast/template.json";

    private Map<String, String> values;

    public WundergroundStub() {
        values = new HashMap<>();
    }

    public String getResponse() {
        Template template = new Template(FORECAST_TEMPLATE, values);
        try {
            return template.render();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setTodaysForecast(String value) {
        values.put("TODAYS_FORECAST", value);
    }

    public void setTonightsForecast(String value) {
        //TODO add something here
    }

    public void setTomorrowsForecast(String value) {
        //TODO add something here
    }

    public void setTomorrowNightsForecast(String value) {
        //TODO add something here
    }

}
