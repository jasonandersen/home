package vashaina.ha.weather.ext.domain;

/**
 * A single temperature data point.
 */
public class Temperature {

    public enum Scale {
        CELCIUS,
        FAHRENHEIT
    }

    private final double temperature;

    private final Scale scale;

    /**
     * Constructor
     * @param temperature
     * @param scale
     */
    public Temperature(double temperature, Scale scale) {
        this.temperature = temperature;
        this.scale = scale;
    }

    public double getTemperature() {
        return temperature;
    }

    public Scale getScale() {
        return scale;
    }

    @Override
    public String toString() {
        return String.format("%.0f°F", temperature);
    }

}
