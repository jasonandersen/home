package vashaina.ha.weather.ext.cucumber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Base class that all cucumber step definition classes should extend.
 */
@ContextConfiguration(locations = { "classpath:features/cucumber.xml" })
public abstract class BaseCucumberSteps {

    protected static final String KEY_REQUEST_ZIP = "request.zipcode";
    protected static final String KEY_WG_STUB = "wunderground.stub";
    protected static final String KEY_WG_FORECAST_TODAY = "wunderground.response.forecast.today";
    protected static final String KEY_WG_FORECAST_TONIGHT = "wunderground.response.forecast.tonight";
    protected static final String KEY_WG_FORECAST_TOMORROW = "wunderground.response.forecast.tomorrow";
    protected static final String KEY_WG_FORECAST_TOMORROW_NIGHT = "wunderground.response.forecast.tomorrow.night";
    protected static final String KEY_SUT_RESPONSE = "wunderground.response";

    private static final Logger log = LoggerFactory.getLogger(BaseCucumberSteps.class);

    @Autowired
    private TestContext textContext;

    /**
     * Every child class needs to implement this method, add the @After annotation
     * and call the tearDownTestContext() method. I do it this way because
     * Cucumber doesn't allow an @After hook from an abstract class.
     */
    public abstract void tearDown();

    /**
     * Clean up after all tests. Reset test context so it's ready and clean for the next test.
     */
    protected void tearDownTestContext() {
        log.debug("tearing down");
        textContext.reset();
    }

    /**
     * Retrieve a value out of the test context.
     * @param key
     * @return
     */
    protected <T> T get(String key) {
        return textContext.get(key);
    }

    /**
     * Set a value into test context.
     * @param key
     * @param value
     */
    protected void put(String key, Object value) {
        textContext.set(key, value);
    }

}