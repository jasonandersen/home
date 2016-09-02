package vashaina.ha.service.virtual;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Any tests needing a Spring context should extend this class
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/service-virtualization-context.xml" })
public abstract class IntegrationTest {
    //NOOP - just need the spring annotations
}
