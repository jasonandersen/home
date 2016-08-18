package vashaina.ha.weather.ext.fitnesse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Executes a test to call a service from a SLIM TableTable fixture.
 */
public class ServiceCallFixture {

    private static final String NO_RESULT = "ignore"; //didn't pass or fail
    private static final int IDX_VERB = 0;
    private static final int IDX_URL = 1;
    private static final int IDX_EXPECTED_STATUS = 2;
    private static final int IDX_EXPECTED_RESPONSE = 3;
    private static final int NUM_COLUMNS = 4;

    /**
     * Fitnesse entrypoint
     * @param table
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List doTable(List<List<String>> table) {
        List<TestCase> testCases = parseTestCases(table);
        executeTestCases(testCases);
        return buildOutcome(testCases);
    }

    /**
     * Parse the incoming table into individual test cases.
     * @param table
     */
    private List<TestCase> parseTestCases(List<List<String>> table) {
        /*
         * Loop through all the rows in the table skipping over the first one
         */
        List<TestCase> testCases = new ArrayList<>();
        for (int index = 1; index < table.size(); index++) {
            List<String> row = table.get(index);
            TestCase testCase = new TestCase(row.get(IDX_VERB), row.get(IDX_URL), row.get(IDX_EXPECTED_STATUS),
                    row.get(IDX_EXPECTED_RESPONSE));
            testCases.add(testCase);
        }
        return testCases;
    }

    /**
     * Execute all the test cases.
     * @param testCases
     */
    private void executeTestCases(List<TestCase> testCases) {
        TestCaseExecutor executor = new TestCaseExecutor(testCases);
        executor.execute();
    }

    /**
     * Builds the outcome response list.
     * @param testCases
     */
    @SuppressWarnings("rawtypes")
    private List buildOutcome(List<TestCase> testCases) {
        /*
         * TODO change data structure to array so we don't have to hardcode the column order
         */
        List<List<String>> table = new ArrayList<>();
        table.add(buildHeaderRow());
        for (TestCase testCase : testCases) {
            List<String> row = buildOutcomeRow(testCase);
            table.add(row);
        }
        return table;
    }

    /**
     * Builds a header row to mark the results of the first row
     * @param testCase
     * @return just a dummy list of pass fields
     */
    private List<String> buildHeaderRow() {
        return buildReturnRow(NO_RESULT, NO_RESULT, NO_RESULT, NO_RESULT);
    }

    /**
     * @param testCase
     * @return a list of responses for a single test case
     */
    private List<String> buildOutcomeRow(TestCase testCase) {
        return buildReturnRow(
                NO_RESULT,
                testCase.getVerbOutcomeMessage(),
                NO_RESULT,
                testCase.getResponseOutcomeMessage());
    }

    /**
     * Builds a single row
     * @param verbOutcome
     * @param urlOutcome
     * @param statusCodeOutcome
     * @param responseOutcome
     * @return
     */
    private List<String> buildReturnRow(String verbOutcome, String urlOutcome, String statusCodeOutcome, String responseOutcome) {
        String[] array = new String[NUM_COLUMNS];
        array[IDX_VERB] = verbOutcome;
        array[IDX_URL] = urlOutcome;
        array[IDX_EXPECTED_STATUS] = statusCodeOutcome;
        array[IDX_EXPECTED_RESPONSE] = responseOutcome;
        return Arrays.asList(array);
    }

}
