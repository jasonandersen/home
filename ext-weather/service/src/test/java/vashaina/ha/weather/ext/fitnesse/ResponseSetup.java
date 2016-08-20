package vashaina.ha.weather.ext.fitnesse;

import java.util.HashMap;
import java.util.Map;

/**
 * Fixture to store JSON responses for Fitnesse wunderground service tests.
 */
@Deprecated
public class ResponseSetup {

    private String zip;

    private String response;

    private final Map<String, String> responses;

    public ResponseSetup() {
        responses = new HashMap<>();
    }

    /**
     * This is a hack to hook into Fitnesse's lifecycle to get the zip code and response
     * registered in the tables. It's a terrible design and I need to figure out a better 
     * way to do this. So hack ahead...
     * @return always return true
     */
    public boolean registered() {
        responses.put(zip, response);
        zip = null;
        response = null;
        return true;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Map<String, String> getResponses() {
        return responses;
    }

}
