package vashaina.ha.mountebank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vashaina.ha.mountebank.domain.Imposter;
import vashaina.ha.mountebank.domain.Is;
import vashaina.ha.mountebank.domain.Response;
import vashaina.ha.mountebank.domain.Stub;

/**
 * Test the {@link ServiceVirtualizer class.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class ServiceVirtualizerTest {

    private static final String RESPONSE_BODY = "{\"ok\":\"hell yeah\"}";
    @Autowired
    private ServiceVirtualizer service;

    @Test
    public void testDependencyInjection() {
        assertNotNull(service);
    }

    @Test
    public void testBuildImposter() {
        Imposter imposter = service.buildImposter(4545, "/test", "GET", 200, RESPONSE_BODY);
        assertNotNull(imposter);
        assertEquals(4545, imposter.getPort());
        assertEquals("http", imposter.getProtocol());
        assertFalse(imposter.getStubs().isEmpty());
        Stub firstStub = imposter.getStubs().get(0);
        assertFalse(firstStub.getResponses().isEmpty());
        Response firstResponse = firstStub.getResponses().get(0);
        Is is = firstResponse.getIs();
        assertEquals(200, is.getStatusCode());
        assertEquals(RESPONSE_BODY, is.getBody());
    }

}
