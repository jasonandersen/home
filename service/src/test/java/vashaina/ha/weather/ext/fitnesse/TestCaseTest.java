package vashaina.ha.weather.ext.fitnesse;

import static org.junit.Assert.assertEquals;
import static vashaina.ha.weather.ext.fitnesse.TestCase.Result.ERROR;
import static vashaina.ha.weather.ext.fitnesse.TestCase.Result.FAIL;
import static vashaina.ha.weather.ext.fitnesse.TestCase.Result.PASS;

import org.junit.Before;
import org.junit.Test;

/**
 * You: "A test class for a test class? That seems like an anti-pattern. How many
 * layers of inception are we going to go down here?"
 * 
 * Me: "I'm having a problem testing in Fitnesse because I live in the woods with
 * no internet. So to test that my {@link TestCase} test class is working,
 * I'm going to write a test class."
 * 
 * You: <silent judging>
 * 
 * Me: "Fuck off."
 */
public class TestCaseTest {

    private TestCase testCase;

    @Before
    public void setup() {
        testCase = new TestCase("GET", "/test/url", "200 OK", "expected response");
    }

    @Test
    public void testPassingOutcomeResponseMessage() {
        testCase.setResult(PASS);
        assertEquals("pass", testCase.getResponseOutcomeMessage());
    }

    @Test
    public void testFailingOutcomeNoResponseMessage() {
        testCase.setResult(FAIL);
        assertEquals("fail", testCase.getResponseOutcomeMessage());
    }

    @Test
    public void testFailingOutcomeResponseMessage() {
        testCase.setResult(FAIL);
        testCase.setResultMessage("actual response");
        assertEquals("fail: actual response", testCase.getResponseOutcomeMessage());
    }

    @Test
    public void testExceptionOutcomeResponseMessage() {
        Exception exception = new RuntimeException("sonofabiznitch!");
        testCase.setResult(ERROR);
        testCase.setException(exception);
        assertEquals("error: RuntimeException - sonofabiznitch!", testCase.getResponseOutcomeMessage());
    }

    @Test
    public void testPassingOutcomeVerbMessage() {
        testCase.setResult(PASS);
        testCase.setActualStatusCode("200 OK");
        assertEquals("pass:GET [200 OK]", testCase.getVerbOutcomeMessage());
    }

    @Test
    public void testPassingOutcomeNoStatusCodeVerbMessage() {
        testCase.setResult(PASS);
        testCase.setActualStatusCode(null);
        assertEquals("pass:GET", testCase.getVerbOutcomeMessage());
    }

    @Test
    public void testFailingOutcomeVerbMessage() {
        testCase.setResult(FAIL);
        testCase.setActualStatusCode("400 Bad Request");
        assertEquals("fail:GET [400 Bad Request]", testCase.getVerbOutcomeMessage());
    }

    @Test
    public void testFailingOutcomeNoStatusCodeVerbMessage() {
        testCase.setResult(FAIL);
        testCase.setActualStatusCode(null);
        assertEquals("fail:GET", testCase.getVerbOutcomeMessage());
    }

    @Test
    public void testExceptionOutcomeVerbMessage() {
        Exception exception = new RuntimeException("sonofabiznitch!");
        testCase.setResult(ERROR);
        testCase.setException(exception);
        assertEquals("ignore", testCase.getVerbOutcomeMessage());
    }

}
