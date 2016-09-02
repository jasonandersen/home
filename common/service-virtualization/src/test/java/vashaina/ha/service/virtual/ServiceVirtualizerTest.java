package vashaina.ha.service.virtual;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test the {@link ServiceVirtualizer} class.
 */
public class ServiceVirtualizerTest extends IntegrationTest {

    /*
     * NOTE: these tests require an instance of Mountebank running on port 2525.
     */
    private static final String RESPONSE_BODY = "{\"ok\":\"hell yeah\"}";

    @Autowired
    private ServiceVirtualizer service;
    private ServiceDouble serviceDouble;
    private int port = 4545;
    private String path = "/test/path";
    private String method = "GET";
    private int responseStatus = 200;
    private String responseBody = RESPONSE_BODY;

    @Before
    public void setupServiceDouble() {
        service.clearAllDoubles();
        ServiceDoubleRequest request = new ServiceDoubleRequest(port, path, method, responseStatus, responseBody);
        serviceDouble = service.createDouble(request);
    }

    @Test
    public void testDependencyInjection() {
        assertNotNull(service);
    }

    @Test
    public void testServiceDoubleNotNull() {
        assertNotNull(serviceDouble);
    }

    @Test
    public void testServiceDoubleCreated() {
        assertEquals(port, serviceDouble.getPort());
        assertEquals(path, serviceDouble.getPath());
        assertEquals(method, serviceDouble.getMethod());
        assertEquals(responseStatus, serviceDouble.getResponseStatus());
        assertEquals(responseBody, serviceDouble.getResponseBody());
    }

    @Test
    public void testToString() {
        assertEquals("ServiceDouble:method=GET;port=4545;path=/test/path;", serviceDouble.toString());
    }
}
