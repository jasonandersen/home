package vashaina.ha.weather.ext.wunderground;

/**
 * Specifies a service double for calls to the Wunderground API.
 */
public interface WundergroundStub {

    /**
     * @return the expected path
     */
    String getPath();

    /**
     * @return the expected response body when called
     */
    String getResponse();

}