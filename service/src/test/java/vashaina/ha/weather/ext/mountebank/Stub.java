package vashaina.ha.weather.ext.mountebank;

import org.springframework.http.HttpMethod;

/**
 * Stubs out a service call with a URL and a response.
 */
public class Stub {

    private final HttpMethod verb;
    private final String url;
    private final String response;

    /**
     * Constructor
     * @param verb
     * @param url
     * @param response
     */
    public Stub(HttpMethod verb, String url, String response) {
        this.verb = verb;
        this.url = url;
        this.response = response;
    }

    public HttpMethod getVerb() {
        return verb;
    }

    public String getUrl() {
        return url;
    }

    public String getResponse() {
        return response;
    }

}
