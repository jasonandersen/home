package vashaina.ha.weather.ext.service.wunderground;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Represents the host used to call the Wunderground API.
 */
@Component
public class WundergroundHost {

    private static Logger log = LoggerFactory.getLogger(WundergroundHost.class);

    private final String host;

    /**
     * Constructor
     * @param host
     */
    @Autowired
    public WundergroundHost(@Value("${wunderground.host}") String host) {
        Validate.notNull(host);
        this.host = trimTrailingSlashFromHost(host);
        log.info("using Wunderground host {}", this.host);
    }

    /**
     * @param candidate
     * @return a host string with no trailing slash
     */
    protected String trimTrailingSlashFromHost(String candidateHost) {
        if (candidateHost.endsWith("/")) {
            log.warn("Wunderground host configured with trailing slash, should have no trailing slash: {}", candidateHost);
            return candidateHost.substring(0, candidateHost.length() - 1);
        }
        return candidateHost;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return host;
    }

}
