package ss.af.reporting;

import ss.af.reporting.statistics.MethodsStatisticEngine;
import ss.af.reporting.statistics.MethodsStatisticEngineImpl;
import ss.af.reporting.statistics.StatisticsCollector.MethodDurationTuple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SuiteReportChain extends TestReportChain implements SuiteReport {
	private static final String SUITE_STATISTIC_TOP_REUSED_METHODS = "stat-topreused";
	private static final String SUITE_STATISTIC_TOP_UNUSED_METHODS = "stat-topunused";
	private static final String SUITE_STATISTIC_TOP_TIME_CONSUMING_METHODS = "stat-toptimeconsuming";
	private static final String SUITE_STATISTIC_UNIQUE_METHOD_CALLS = "Total unique methods calls";
	private static final String SUITE_STATISTIC_TOTAL_METHOD_CALLS = "Total methods call";
	private static final String SUITE_STATISTIC_METHOD_EXECUTION = "stat-methodexecution";

    /**
     * Adds the link to the specific test report.
     *
     * @param testReportId - The test report's unique identifier.
     */
    public void addLinkToTestReport(TestInformation testReportId) {
        for (TestReport report : reports) {
            if (report instanceof SuiteReport) {
                ((SuiteReport) report).addLinkToTestReport(testReportId);
            }
        }
    }

    public void closeReport(Map<String, String> testEndRunMetadata) {
        int percent = 100;

        MethodsStatisticEngine statisticEngine = new MethodsStatisticEngineImpl(AutomationSuiteContext.getInstance().getStatisticsCollector().getMethodCallsStatistic());

        // Write statistic top reused
        for (Entry<String, Integer> stat : statisticEngine.getTopReusedMethods().entrySet()) {
            for (TestReport rep : reports) {
                HashMap<String, String> attributes = new HashMap<String, String>();
                attributes.put("method", stat.getKey());
                attributes.put("value", stat.getValue().toString());
                rep.writeExecutionInfo(SUITE_STATISTIC_TOP_REUSED_METHODS, attributes);
            }
        }

        // Write statistic top unused
        for (Entry<String, Integer> stat : statisticEngine.getTopUnusedMethods().entrySet()) {
            for (TestReport rep : reports) {
                HashMap<String, String> attributes = new HashMap<String, String>();
                attributes.put("method", stat.getKey());
                attributes.put("value", stat.getValue().toString());
                rep.writeExecutionInfo(SUITE_STATISTIC_TOP_UNUSED_METHODS, attributes);
            }
        }

        // Write statistic top time consuming 
        for (Entry<String, Long> stat : statisticEngine.getTopTimeConsumingMethods().entrySet()) {
            for (TestReport rep : reports) {
                HashMap<String, String> attributes = new HashMap<String, String>();
                attributes.put("method", stat.getKey());
                attributes.put("value", stat.getValue().toString());
                rep.writeExecutionInfo(SUITE_STATISTIC_TOP_TIME_CONSUMING_METHODS, attributes);
            }
        }

        // Write statistic method execution
        for (Entry<String, List<MethodDurationTuple>> stat : statisticEngine.getMethodsExecutionStatistic(percent).entrySet()) {
            for (TestReport rep : reports) {
                HashMap<String, String> attributes = new HashMap<String, String>();
                for (MethodDurationTuple mdt : stat.getValue()) {
                    attributes.put(mdt.callingTest, String.valueOf(mdt.methodDuration));
                }
                attributes.put("methodName", stat.getKey());
                rep.writeExecutionInfo(SUITE_STATISTIC_METHOD_EXECUTION, attributes);
            }
        }

        Map<String, String> statisticData = new HashMap<String, String>();
        statisticData.put(SUITE_STATISTIC_TOTAL_METHOD_CALLS, String.valueOf(statisticEngine.totalMethodCalls()));
        statisticData.put(SUITE_STATISTIC_UNIQUE_METHOD_CALLS, String.valueOf(statisticEngine.totalUniqueMethodCalls()));

        Map<String, String> globalInfo = mergeRuntimeData(statisticData, testEndRunMetadata);

        for (TestReport testReport : reports) {
            testReport.closeReport(globalInfo);
        }
    }

    public void closeReport() {
        closeReport(null);
    }
}
