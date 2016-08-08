package vashaina.ha.weather.domain;

/**
 * A weather forecast.
 */
public class Forecast {
    private final int zip;
    private final int highTemp;

    /**
     * Constructor.
     * @param highTemp
     * @param zip
     */
    public Forecast(int highTemp, int zip) {
        this.highTemp = highTemp;
        this.zip = zip;
    }

    /**
     * @return highest forecasted temperature for this forecast day.
     */
    public int getHighTemp() {
        return highTemp;
    }

    /**
     * @return the zip code relevant for this forecast.
     */
    public int getZip() {
        return zip;
    }
}
