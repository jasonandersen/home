package vashaina.ha.weather.ext.cucumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A response returned from calling the external weather service.
 */
public class ExternalWeatherResponse {

    private final String response;
    private final int statusCode;
    private final Pattern todaysForecastPattern;
    private final Pattern tomorrowsForecastPattern;

    /**
     * Constructor
     * @param rawResponse
     * @param statusCode 
     */
    public ExternalWeatherResponse(String response, int statusCode) {
        this.response = response;
        this.statusCode = statusCode;
        todaysForecastPattern = Pattern.compile("(?<=\"todaysForecast\":\").+?(?=\")");
        tomorrowsForecastPattern = Pattern.compile("(?<=\"tomorrowsForecast\":\").+?(?=\")");
    }

    /**
     * @return today's forecast from the response, will return a blank string if not found
     */
    public String getTodaysForecast() {
        return findSubstring(todaysForecastPattern);
    }

    /**
     * @return the HTTP status code returned from response
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @return tomorrow's forecast from the response, will return a blank string if not found
     */
    public String getTomorrowsForecast() {
        return findSubstring(tomorrowsForecastPattern);
    }

    /**
     * Given a regex pattern, will find a substring in the JSON response
     * @param pattern
     * @return the substring if found, otherwise a blank string
     */
    private String findSubstring(Pattern pattern) {
        if (response == null) {
            return "";
        }

        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

}
