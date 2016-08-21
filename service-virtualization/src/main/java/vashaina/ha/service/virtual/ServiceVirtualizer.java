package vashaina.ha.service.virtual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import vashaina.ha.service.virtual.mountebank.Imposter;

/**
 * Creates service test doubles.
 */
@Service
public class ServiceVirtualizer {

    @Autowired
    private ImposterFactory factory;

    private RestTemplate restTemplate;

    /**
     * 
     * @param port
     * @param path
     * @param method
     * @param responseStatus
     * @param responseBody
     */
    public void createDouble(int port, String path, String method, int responseStatus, String responseBody) {
        Imposter imposter = factory.buildImposter(port, path, method, responseStatus, responseBody);

        /*
        Imposter imposter = buildImposter(port, path, method, responseStatus, responseBody);
        String json = serializeImposter(imposter);
        Imposter registered = registerImposter(imposter);
        */
    }

    /**
     * @param imposter
     * @return
     */
    protected String serializeImposter(Imposter imposter) {
        return null;
    }

    /**
     * @param imposter
     * @return
     */
    protected Imposter registerImposter(Imposter imposter) {
        return null;
    }

}
