package vashaina.ha.weather.ext.service.wunderground;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import vashaina.ha.weather.ext.test.BaseIntegrationTest;

/**
 * Tests the {@link WundergroundHost} class
 */
public class WundergroundHostTest extends BaseIntegrationTest {

    @Autowired
    private WundergroundHost host;

    @Test
    public void testDependencyInjection() {
        assertNotNull(host);
    }

    @Test
    public void testNoTrailingSlash() {
        host = new WundergroundHost("http://api.wunderground.com");
        assertEquals("http://api.wunderground.com", host.toString());
    }

    @Test
    public void testTrailingSlash() {
        host = new WundergroundHost("http://api.wunderground.com/");
        assertEquals("http://api.wunderground.com", host.toString());
    }

}
