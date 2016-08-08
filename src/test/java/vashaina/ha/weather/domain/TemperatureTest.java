package vashaina.ha.weather.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test the @{Temperature} class.
 */
public class TemperatureTest {

    private Temperature temp;

    @Test
    public void testHappyPath() {
        temp = new Temperature(105.0, Temperature.Scale.FAHRENHEIT);
        assertEquals(105.0, temp.getTemperature(), 0.001);
        assertEquals(Temperature.Scale.FAHRENHEIT, temp.getScale());
    }

    @Test
    public void testToString() {
        temp = new Temperature(105.0, Temperature.Scale.FAHRENHEIT);
        assertEquals("105°F", temp.toString());
    }

}
