package vashaina.ha.mountebank;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vashaina.ha.mountebank.domain.Imposter;
import vashaina.ha.mountebank.domain.Stub;

/**
 * 
 */
@Service
public class ServiceVirtualizer {

    private static final String DEFAULT_PROTOCOL = "http";

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
        Imposter imposter = new Imposter();
        imposter.setPort(port);
        imposter.setProtocol(DEFAULT_PROTOCOL);
        List<Stub> stubs = new ArrayList<>();
        return imposter;
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
