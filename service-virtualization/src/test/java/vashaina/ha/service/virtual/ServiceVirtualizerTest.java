package vashaina.ha.service.virtual;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import vashaina.ha.service.virtual.ServiceVirtualizer;

/**
 * Test the {@link ServiceVirtualizer} class.
 */
public class ServiceVirtualizerTest {

    @Autowired
    private ServiceVirtualizer service;

    @Test
    public void testDependencyInjection() {
        assertNotNull(service);
    }
}
