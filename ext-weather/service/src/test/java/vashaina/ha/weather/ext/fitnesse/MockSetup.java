package vashaina.ha.weather.ext.fitnesse;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class MockSetup {

    private static final String PASS = "pass";

    @SuppressWarnings("rawtypes")
    public List doTable(List<List<String>> table) {
        return generateFakeOut();
    }

    @SuppressWarnings("rawtypes")
    private List generateFakeOut() {
        List<String> row = new ArrayList<>();
        row.add(PASS);
        row.add(PASS);
        row.add(PASS);
        row.add(PASS);
        List<List<String>> out = new ArrayList<>();
        out.add(row);
        return out;
    }

}
