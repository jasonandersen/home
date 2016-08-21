package vashaina.ha.mountebank;

import org.springframework.stereotype.Service;

import vashaina.ha.mountebank.domain.Imposter;

/**
 * 
 */
@Service
public class ServiceVirtualizer {

    /**
     * 
     * @param port
     * @param path
     * @param method
     * @param responseStatus
     * @param responseBody
     */
    public void createDouble(int port, String path, String method, int responseStatus, String responseBody) {
        Imposter imposter = buildImposter(port, path, method, responseStatus, responseBody);
        String json = serializeImposter(imposter);
        Imposter registered = registerImposter(imposter);
    }

    /**
     * 
     * @param port
     * @param path
     * @param method
     * @param responseStatus
     * @param responseBody
     * @return 
     */
    protected Imposter buildImposter(int port, String path, String method, int responseStatus, String responseBody) {
        return null;
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
