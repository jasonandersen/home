package vashaina.ha.weather.ext.domain;

/**
 * A weather forecast for a particular zip code.
 */
public class Forecast {

    private final String todaysForecast;

    private final String tomorrowsForecast;

    /**
     * Constructor.
     * @param highTemp
     * @param zip
     */
    public Forecast(String todaysForecast, String tomorrowsForecast) {
        this.todaysForecast = todaysForecast;
        this.tomorrowsForecast = tomorrowsForecast;
    }

    /**
     * @return forecast text for today
     */
    public String getTodaysForecast() {
        return todaysForecast;
    }

    /**
     * @return forecast text for tomorrow
     */
    public String getTomorrowsForecast() {
        return tomorrowsForecast;
    }
}
