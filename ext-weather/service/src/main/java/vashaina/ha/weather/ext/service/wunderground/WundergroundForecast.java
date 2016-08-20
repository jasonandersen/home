package vashaina.ha.weather.ext.service.wunderground;

import java.util.List;

import vashaina.ha.weather.ext.service.wunderground.response.Forecast;
import vashaina.ha.weather.ext.service.wunderground.response.ForecastDayText;
import vashaina.ha.weather.ext.service.wunderground.response.ForecastResponse;
import vashaina.ha.weather.ext.service.wunderground.response.Response;
import vashaina.ha.weather.ext.service.wunderground.response.TextForecast;

/**
 * Wraps the {@link ForecastResponse} class to provide some convenience methods
 * and provide resiliency to null values in the response. This class should protect
 * the outside world from any {@link NullPointerException}s that are likely to
 * result in the response being malformed. It should also hide the rather gnarly
 * object graph that Wunderground returns in their response. All interaction with
 * Wunderground forecast responses should go through this class.
 * 
 * This class follows the "Tolerant Reader" pattern.
 * @see http://martinfowler.com/bliki/TolerantReader.html
 */
public class WundergroundForecast {

    private static final int IDX_TODAYS_FORECAST = 0;
    private static final int IDX_TOMORROWS_FORECAST = 1;

    private final ForecastResponse forecastResponse;

    private final String url;

    /**
     * Constructor
     * @param response
     * @param url
     * @throws IllegalArgumentException if url is null or empty
     */
    public WundergroundForecast(ForecastResponse response, String url) {
        if (url == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (url.isEmpty()) {
            throw new IllegalArgumentException("url cannot be empty string");
        }
        this.forecastResponse = response;
        this.url = url;
    }

    /**
     * @return the URL called to retrieve this forecast object, will never return null or empty string
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the version number of the API, will return a blank string if the version
     *      cannot be retrieved out of the forecast response - never returns null
     */
    public String getApiVersion() {
        Response response = getResponse();
        if (response != null) {
            if (response.getVersion() != null) {
                return response.getVersion();
            }
        }
        return "";
    }

    /**
     * @return the text of today's forecast, will return blank string if today's 
     *      forecast cannot be retrieved out of the response - will never return null
     */
    public String getTodaysForecast() {
        return getTextForecast(IDX_TODAYS_FORECAST);
    }

    /**
     * @return the text of tomorrow's forecast, will return blank string if tomorrow's
     *      forecast cannot be retrieved out of the response - never returns null
     */
    public String getTomorrowsTextForecast() {
        return getTextForecast(IDX_TOMORROWS_FORECAST);
    }

    /**
     * @return the text of the forecast specified at the index, will return blank string 
     *      if tomorrow's forecast cannot be retrieved out of the response - never returns null
     */
    private String getTextForecast(int index) {
        ForecastDayText forecast = getForecastDayText(index);
        if (forecast != null) {
            if (forecast.getFcttext() != null) {
                return forecast.getFcttext();
            }
        }
        return "";
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String format = "%s:url=%s;apiVersion=%s";
        return String.format(format, this.getClass().getSimpleName(), url, getApiVersion());
    }

    /**
     * @param index
     * @return a day's text forecast, will return null if the forecast days list is null or empty
     */
    private ForecastDayText getForecastDayText(int index) {
        List<ForecastDayText> forecastDays = getForecastDaysText();
        if (forecastDays != null) {
            if (forecastDays.size() > index) {
                return forecastDays.get(index);
            }
        }
        return null;
    }

    /**
     * @return the list of text forecast days, will return null if the text forecast object is null
     */
    private List<ForecastDayText> getForecastDaysText() {
        return getTextForecast() == null ? null : getTextForecast().getForecastDays();
    }

    /**
     * @return the text forecast, will return null if the forecast object is null
     */
    private TextForecast getTextForecast() {
        return getForecast() == null ? null : getForecast().getTxtForecast();
    }

    /**
     * @return the forecast object, will return null if the response is null
     */
    private Forecast getForecast() {
        return forecastResponse == null ? null : forecastResponse.getForecast();
    }

    /**
     * @return the response object, will return null if the forecastResponse is null
     */
    private Response getResponse() {
        return forecastResponse == null ? null : forecastResponse.getResponse();
    }

}
