package vashaina.ha.weather.ext.cucumber;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import vashaina.ha.service.virtual.ServiceDouble;
import vashaina.ha.service.virtual.ServiceDoubleRequest;
import vashaina.ha.service.virtual.ServiceVirtualizer;

/**
 * Proxies requests out to the ext-weather service, stubbing out the
 * downstream Wunderground API dependency.
 */
@Component
public class ExternalWeatherGateway {

    private static final int WG_PORT = 7575;
    private static final int RESPONSE_CODE = 200;
    private static final String HTTP_METHOD = "GET";

    @Value("${mountebank.host.name}")
    private String mountebankHost;
    @Value("${wunderground.api.key}")
    private String wundergroundApiKey;
    @Value("${ext.weather.host}")
    private String serviceHost;
    @Value("${ext.weather.port}")
    private String servicePort;
    @Autowired
    private ServiceVirtualizer virtualizer;

    /**
     * Executes a call to the external weather service.
     * @param stub 
     * @param zip 
     * @return the response from the external weather service
     */
    public ExternalWeatherResponse execute(String zip, WundergroundStub stub) {
        setupServiceDouble(zip, stub);
        String url = buildServiceUrl(zip);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return new ExternalWeatherResponse(response.getBody(), response.getStatusCodeValue());
    }

    /**
     * @param zip
     * @return the URL used to call the system under test
     */
    private String buildServiceUrl(String zip) {
        return String.format("http://%s:%s/weather/forecast/%s", serviceHost, servicePort, zip);
    }

    /**
     * @param zip
     * @param stub
     * @return a properly built request for a service double
     */
    private void setupServiceDouble(String zip, WundergroundStub stub) {
        String path = buildWundergroundPath(zip);
        String response = stub.getResponse();
        ServiceDoubleRequest request = new ServiceDoubleRequest(WG_PORT, path, HTTP_METHOD, RESPONSE_CODE, response);
        ServiceDouble serviceDouble = virtualizer.createDouble(request);
        assertEquals(path, serviceDouble.getPath());
    }

    /**
     * @param zip
     * @return the path portion of the wunderground API url
     */
    private String buildWundergroundPath(String zip) {
        return String.format("/api/%s/forecast/q/%s.json", wundergroundApiKey, zip);
    }

}
