package vashaina.ha.service.virtual;

import vashaina.ha.service.virtual.mountebank.Equals;
import vashaina.ha.service.virtual.mountebank.Imposter;
import vashaina.ha.service.virtual.mountebank.Is;
import vashaina.ha.service.virtual.mountebank.Predicate;
import vashaina.ha.service.virtual.mountebank.Response;
import vashaina.ha.service.virtual.mountebank.Stub;

/**
 * A service double registered with the service virtualization.
 */
public class ServiceDouble {

    /*
     * We're going through a lot of work to make sure this class is tolerant of whatever
     * the hell shows up in the imposter. Most of this code is just guard code against
     * NullPointerExceptions.
     */

    private final Imposter imposter;

    /**
     * Constructor
     * @param imposter
     */
    public ServiceDouble(Imposter imposter) {
        this.imposter = imposter;
    }

    /**
     * @return the port this double is answering on, will return 0 if the port has not been correctly set
     */
    public int getPort() {
        Integer port = imposter.getPort();
        return port == null ? 0 : port;
    }

    /**
     * @return the path this double is answering on, will return a blank string if not found
     */
    public String getPath() {
        Equals equals = getEqualsPredicate();
        if (equals != null) {
            return equals.getPath() != null ? equals.getPath() : "";
        }
        return "";
    }

    /**
     * @return the HTTP verb this double will answer to, will return a blank string if not found
     */
    public String getMethod() {
        Equals equals = getEqualsPredicate();
        if (equals != null) {
            return equals.getMethod() != null ? equals.getMethod() : "";
        }
        return "";
    }

    /**
     * @return the response status code this double will return, will return -1 if not found
     */
    public int getResponseStatus() {
        Is is = getIs();
        if (is != null) {
            return is.getStatusCode();
        }
        return -1;
    }

    /**
     * @return the response body this double will return, will return a blank string if not found
     */
    public String getResponseBody() {
        Is is = getIs();
        if (is != null) {
            return is.getBody() != null ? is.getBody() : "";
        }
        return "";
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s:method=%s;port=%d;path=%s;",
                this.getClass().getSimpleName(), getMethod(), getPort(), getPath());

    }

    /**
     * @return the equals predicate, will return null if not set
     */
    private Equals getEqualsPredicate() {
        Predicate firstPredicate = getFirstPredicate();
        if (firstPredicate != null) {
            return firstPredicate.getEquals();
        }
        return null;
    }

    /**
     * @return the first predicate in the first stub, will return null if not found
     */
    private Predicate getFirstPredicate() {
        Stub firstStub = getFirstStub();
        if (firstStub != null) {
            if (firstStub.getPredicates() != null && !firstStub.getPredicates().isEmpty()) {
                return firstStub.getPredicates().get(0);
            }
        }
        return null;
    }

    /**
     * @return the first stub, will return null if the stub isn't set
     */
    private Stub getFirstStub() {
        if (imposter.getStubs() != null && !imposter.getStubs().isEmpty()) {
            return imposter.getStubs().get(0);
        }
        return null;
    }

    /**
     * @return the is response, will return null if not found
     */
    private Is getIs() {
        Response response = getFirstResponse();
        if (response != null) {
            return response.getIs();
        }
        return null;
    }

    /**
     * @return the first response setup, will return null if not found
     */
    private Response getFirstResponse() {
        Stub firstStub = getFirstStub();
        if (firstStub != null) {
            if (firstStub.getResponses() != null && !firstStub.getResponses().isEmpty()) {
                return firstStub.getResponses().get(0);
            }
        }
        return null;
    }

}
