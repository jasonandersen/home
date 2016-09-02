package vashaina.ha.service.virtual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import vashaina.ha.service.virtual.mountebank.Imposter;

/**
 * Creates service test doubles.
 */
@Service
public class ServiceVirtualizer {

    private static Logger log = LoggerFactory.getLogger(ServiceVirtualizer.class);

    @Autowired
    private ImposterFactory factory;
    @Value("${mountebank.host.name}")
    private String mountebankHost;
    @Value("${mountebank.host.port}")
    private String mountebankPort;
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Clears all service doubles.
     */
    public void clearAllDoubles() {
        log.info("deleting all imposters");
        restTemplate.delete(constructUrl("/imposters"));
    }

    /**
     * Creates a service test double with the service virtualization service.
     * @param port
     * @param path
     * @param method
     * @param responseStatus
     * @param responseBody
     * @return the service double created by the virtualization service
     */
    public ServiceDouble createDouble(ServiceDoubleRequest request) {
        Imposter imposter = factory.buildImposter(request);
        log.info("registering service double on port {} for path {}", request.getPort(), request.getPath());
        Imposter registered = registerImposter(imposter);
        ServiceDouble serviceDouble = new ServiceDouble(registered);
        log.info("service double registered: {}", serviceDouble);
        return serviceDouble;
    }

    /**
     * Registers the imposter with the Mountebank server.
     * @param imposter
     * @return the imposter returned from the Mountebank call
     */
    protected Imposter registerImposter(Imposter imposter) {
        String url = constructUrl("/imposters");
        return restTemplate.postForObject(url, imposter, Imposter.class);
    }

    /**
     * @param path
     * @return a properly formatted URL string to call mountebank
     */
    private String constructUrl(String path) {
        return String.format("http://%s:%s%s", mountebankHost, mountebankPort, path);
    }

}
