package vashaina.ha.weather.ext.fitnesse;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import vashaina.ha.weather.ext.fitnesse.TestCase.Result;
import vashaina.ha.weather.ext.test.TestUtils;

/**
 * Executes individual {@link TestCase}s and records their results.
 */
public class TestCaseExecutor {

    private final List<TestCase> testCases;

    /**
     * Constructor
     * @param testCases
     */
    public TestCaseExecutor(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    /**
     * Executes all the test cases and records results.
     */
    public void execute() {
        for (TestCase testCase : testCases) {
            executeTestCase(testCase);
        }
    }

    /**
     * Executes a single test case
     * @param testCase
     */
    private void executeTestCase(TestCase testCase) {
        try {
            ResponseEntity<String> response = TestUtils.fetchJsonResponse(testCase.getUrl(), HttpMethod.GET);
            String responseBody = response.getBody();
            testCase.setActualResponse(responseBody);
            HttpStatus status = response.getStatusCode();
            String statusCode = String.format("%s %s", status.toString(), status.getReasonPhrase());
            testCase.setActualStatusCode(statusCode);
            evaluateTestCaseResults(testCase);
        } catch (Exception e) {
            testCase.setResult(Result.ERROR);
            testCase.setException(e);
        }

    }

    /**
     * Sets the result property in the test case based on whether the expected results were returned.
     * @param testCase
     */
    private void evaluateTestCaseResults(TestCase testCase) {
        boolean responseMatches = actualResponseMatchesExpectedResponse(testCase);
        testCase.setResult(responseMatches ? Result.PASS : Result.FAIL);
    }

    /**
     * @param testCase
     * @return true if minified version of actual response matches minified version of expected response
     */
    private boolean actualResponseMatchesExpectedResponse(TestCase testCase) {
        String actual = TestUtils.minifyJson(testCase.getActualResponse());
        String expected = TestUtils.minifyJson(testCase.getExpectedResponse());
        return expected.equals(actual);
    }
}
