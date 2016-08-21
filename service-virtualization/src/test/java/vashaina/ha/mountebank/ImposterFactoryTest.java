package vashaina.ha.mountebank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vashaina.ha.mountebank.domain.Equals;
import vashaina.ha.mountebank.domain.Imposter;
import vashaina.ha.mountebank.domain.Is;
import vashaina.ha.mountebank.domain.Predicate;
import vashaina.ha.mountebank.domain.Response;
import vashaina.ha.mountebank.domain.Stub;

/**
 * Test the {@link ImposterFactory} class.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class ImposterFactoryTest {

    private static final String RESPONSE_BODY = "{\"ok\":\"hell yeah\"}";

    @Autowired
    private ImposterFactory factory;

    @Test
    public void testDependencyInjection() {
        assertNotNull(factory);
    }

    @Test
    public void testResponse() {
        Response firstResponse = loadFirstResponse(4545, "/test", "GET", 200, RESPONSE_BODY);
        Is is = firstResponse.getIs();
        assertNotNull(is);
        assertEquals(200, is.getStatusCode());
        assertEquals(RESPONSE_BODY, is.getBody());
    }

    @Test
    public void testPredicate() {
        Predicate predicate = loadFirstPredicate(4545, "/test", "GET", 200, RESPONSE_BODY);
        assertNotNull(predicate);
        Equals equals = predicate.getEquals();
        assertNotNull(equals);
        assertEquals("/test", equals.getPath());
        assertEquals("GET", equals.getMethod());
    }

    private Predicate loadFirstPredicate(int port, String path, String method, int responseStatus, String responseBody) {
        Stub firstStub = loadFirstStub(port, path, method, responseStatus, responseBody);
        assertFalse(firstStub.getPredicates().isEmpty());
        return firstStub.getPredicates().get(0);
    }

    private Response loadFirstResponse(int port, String path, String method, int responseStatus, String responseBody) {
        Stub firstStub = loadFirstStub(port, path, method, responseStatus, responseBody);
        assertFalse(firstStub.getResponses().isEmpty());
        return firstStub.getResponses().get(0);
    }

    private Stub loadFirstStub(int port, String path, String method, int responseStatus, String responseBody) {
        Imposter imposter = factory.buildImposter(port, path, method, responseStatus, responseBody);
        assertNotNull(imposter);
        assertEquals(port, imposter.getPort());
        assertEquals("http", imposter.getProtocol());
        assertFalse(imposter.getStubs().isEmpty());
        return imposter.getStubs().get(0);
    }

}
