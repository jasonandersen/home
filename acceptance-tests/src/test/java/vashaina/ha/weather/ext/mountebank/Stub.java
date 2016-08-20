package vashaina.ha.weather.ext.mountebank;

/**
 * Stubs out a service call with a URL and a response.
 */
public class Stub {

    private final String verb;
    private final String url;
    private final String response;

    /**
     * Constructor
     * @param verb
     * @param url
     * @param response
     */
    public Stub(String verb, String url, String response) {
        this.verb = verb;
        this.url = url;
        this.response = response;
    }

    public String getVerb() {
        return verb;
    }

    public String getUrl() {
        return url;
    }

    public String getResponse() {
        return response;
    }

}
