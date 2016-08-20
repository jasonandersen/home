package vashaina.ha.weather.ext.fitnesse;

/**
 * Fitnesse fixture to call the weather forecast service.
 */
@Deprecated
public class ExternalWeatherController {

    private String zip;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}
