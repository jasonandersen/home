package vashaina.ha.weather.ext.driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A response returned from calling the external weather service.
 */
public class Response {

    private final String response;
    private final int statusCode;
    private final Pattern todaysForecastPattern;
    private final Pattern tomorrowsForecastPattern;
    private final Pattern sourcePattern;
    private final Pattern zipPattern;

    /**
     * Constructor
     * @param rawResponse
     * @param statusCode 
     */
    public Response(String response, int statusCode) {
        this.response = response;
        this.statusCode = statusCode;
        todaysForecastPattern = Pattern.compile("(?<=\"todaysForecast\":\").+?(?=\")");
        tomorrowsForecastPattern = Pattern.compile("(?<=\"tomorrowsForecast\":\").+?(?=\")");
        sourcePattern = Pattern.compile("(?<=\"source\":\").+?(?=\")");
        zipPattern = Pattern.compile("(?<=\"zipCode\":\").+?(?=\")");
    }

    /**
     * @return the text of the response body
     */
    public String getResponseBody() {
        return response;
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
     * @return the forecast's original source
     */
    public String getSource() {
        return findSubstring(sourcePattern);
    }

    /**
     * @return the forecast's zip code
     */
    public String getZip() {
        return findSubstring(zipPattern);
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

    /**
     * @return true if this response has an error
     */
    public boolean hasError() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * @return the type of the error
     */
    public String getErrorType() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * @return the message in the error
     */
    public String getErrorMessage() {
        throw new UnsupportedOperationException("not implemented yet");
    }

}
