package vashaina.ha.weather.ext.fitnesse;

/**
 * This is a single row in the Fitnesse table that will represent a single
 * test case.
 */
public class TestCase {

    public enum Result {
        PASS {
            @Override
            public String toString() {
                return "pass";
            }
        },
        FAIL {
            @Override
            public String toString() {
                return "fail";
            }
        },
        ERROR {
            @Override
            public String toString() {
                return "error";
            }
        }
    }

    private static final String IGNORE = "ignore";

    private final String verb;
    private final String url;
    private final String expectedResponse;
    private final String expectedStatusCode;
    private String actualResponse;
    private String actualStatusCode;
    private Result result;
    private String resultMessage;
    private Exception exception;

    public TestCase(String verb, String url, String expectedStatusCode, String expectedResponse) {
        this.verb = verb;
        this.url = url;
        this.expectedStatusCode = expectedStatusCode;
        this.expectedResponse = expectedResponse;
    }

    public boolean passed() {
        return result == Result.PASS;
    }

    public String getVerb() {
        return verb;
    }

    public String getUrl() {
        return url;
    }

    public String getExpectedStatusCode() {
        return expectedStatusCode;
    }

    public String getExpectedResponse() {
        return expectedResponse;
    }

    public String getActualResponse() {
        return actualResponse;
    }

    public void setActualResponse(String actualResponse) {
        this.actualResponse = actualResponse;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public void setActualStatusCode(String actualStatusCode) {
        this.actualStatusCode = actualStatusCode;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    /**
     * @return an outcome message to be parsed by Fitnesse to control the display
     *      of the Code cell
     */
    public String getVerbOutcomeMessage() {
        String code = "";
        if (actualStatusCode != null && !actualStatusCode.isEmpty()) {
            code = String.format(" [%s]", actualStatusCode);
        }
        if (result == null) {
            return IGNORE;
        }
        switch (result) {
        case ERROR:
            return IGNORE;
        default:
            return String.format("%s:%s%s", result, verb, code);
        }
    }

    /**
     * @return an outcome message to be parsed by Fitnesse to control the display
     *      of the Response cell
     */
    public String getResponseOutcomeMessage() {
        if (result == null) {
            return IGNORE + ": <Test was not executed>";
        }
        switch (result) {
        case PASS:
            return result.toString();
        case FAIL:
            return getFailureMessage();
        case ERROR:
            return getErrorMessage();
        }
        throw new IllegalArgumentException("could not calculate an outcome for result type: " + result);
    }

    /**
     * @return a message for test cases that resulted in exceptions
     */
    private String getErrorMessage() {
        StringBuilder builder = new StringBuilder().append(result);
        if (exception != null) {
            builder.append(": ").append(exception.getClass().getSimpleName());
            builder.append(" - ").append(exception.getMessage());
        }
        return builder.toString();
    }

    /**
     * @return a message for failed test cases
     */
    private String getFailureMessage() {
        StringBuilder builder = new StringBuilder().append(result);
        if (resultMessage != null) {
            if (!resultMessage.isEmpty()) {
                builder.append(": ").append(resultMessage);
            }
        }
        return builder.toString();
    }

}
