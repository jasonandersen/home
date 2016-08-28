package vashaina.ha.weather.ext.cucumber;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import vashaina.ha.service.virtual.ServiceDouble;
import vashaina.ha.service.virtual.ServiceDoubleRequest;
import vashaina.ha.service.virtual.ServiceVirtualizer;
import vashaina.ha.weather.ext.wunderground.WundergroundDouble;

/**
 * Proxies requests out to the ext-weather service, stubbing out the
 * downstream Wunderground API dependency.
 */
@Component
public class ExternalWeatherGateway {

    private static Logger log = LoggerFactory.getLogger(ExternalWeatherGateway.class);

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
    public ExternalWeatherResponse execute(String zip, WundergroundDouble stub) {
        try {
            setupServiceDouble(zip, stub);
            String url = buildServiceUrl(zip);
            log.info("calling external weather service at {}", url);
            ResponseEntity<String> responseEntity = callService(url);
            log.debug("external weather response {}: {}",
                    responseEntity.getStatusCode().toString(), responseEntity.getBody());
            ExternalWeatherResponse response = new ExternalWeatherResponse(
                    responseEntity.getBody(), responseEntity.getStatusCodeValue());
            return response;
        } finally {
            /*
             * make sure we're tearing down our service doubles after execution!
             */
            virtualizer.clearAllDoubles();
        }
    }

    /**
     * @param url
     * @return a response entity from calling the URL
     */
    private ResponseEntity<String> callService(String url) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> request = new HttpEntity<>(headers);
        HttpMethod verb = HttpMethod.GET;
        return restTemplate.exchange(url, verb, request, String.class);
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
    private void setupServiceDouble(String zip, WundergroundDouble stub) {
        String path = stub.getPath();
        String response = stub.getResponse();
        ServiceDoubleRequest request = new ServiceDoubleRequest(WG_PORT, path, HTTP_METHOD, RESPONSE_CODE, response);
        ServiceDouble serviceDouble = virtualizer.createDouble(request);
        assertEquals(path, serviceDouble.getPath());
    }

}
