package ss.af.reporting.baseclasses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ss.af.reporting.AutomationSuiteContext;
import ss.af.reporting.TestReportChain;
import ss.af.reporting.impl.xml.XmlTestInformation;
import ss.af.reporting.statistics.StatisticsCollector.MethodDurationTuple;
import ss.af.reporting.utils.Utils;

public abstract class AutoTestWithReporting {
	private long testStartTime;
	//	public AutomationTestContext AutomationTestContext { get; private set; }
	private TestReportChain testReport;

	protected AutoTestWithReporting() {
		//         AutomationTestContext = new AutomationTestContext();
		testReport = new TestReportChain();
        testStartTime = System.currentTimeMillis();
	}

	/**
	 * Performs default initialization.
	 */
	public void defaultInitialize() {
		AutomationSuiteContext.getInstance().setCurrentExecutedTest(this);
	}

	/**
	 * Performs cleanup.
	 *
	 * @param testName        - Name of the test.
	 * @param testResult      - The test result.
	 * @param endTestMetadata - The end test metadata.
	 */
	public void cleanup(String testName, boolean testResult, Map<String, String> endTestMetadata) {
		long testDuration = System.currentTimeMillis() - testStartTime;
		if (!testResult) {
			AutomationSuiteContext.getInstance().incrementFailedTests();
		} else {
			AutomationSuiteContext.getInstance().incrementPassedTests();
		}

		XmlTestInformation xmlInfo = new XmlTestInformation();
		xmlInfo.setReportPath(testName + ".html");
		xmlInfo.setTestResult(testResult);
		xmlInfo.setDuration(testDuration);
		xmlInfo.setTestIdentifier(testName);
		AutomationSuiteContext.getInstance().getSuiteReport().addLinkToTestReport(xmlInfo);

		// System info
		Map<String, String> generalMetadata = Utils.getSystemGeneralInfo();
		// Test Duration
		generalMetadata.put("Test Duration", Utils.formatTimeNoTimeZone("HH:mm:ss.SSS", testDuration));
		// Test statistic

		Map<String, List<MethodDurationTuple>> methodStatistics;
		methodStatistics = AutomationSuiteContext.getInstance().getStatisticsCollector().getMethodCallsStatistic();
		Map<String, String> calculatedMethodStatistics = calculateTestMethodsCalls(methodStatistics);
		generalMetadata.putAll(calculatedMethodStatistics); // .ForEach(mt => generalMetadata.Add(mt.Key, mt.Value));
		// Merge metadata
		if (endTestMetadata != null) {
			//			generalMetadata = generalMetadata.Concat(endTestMetadata).GroupBy(d => d.Key).ToDictionary(d => d.Key, d => d.Last().Value);
			generalMetadata.putAll(endTestMetadata);
		}

		testReport.writeTestResult(testResult, "Test Result");
		testReport.closeReport(generalMetadata);
	}

	private Map<String, String> calculateTestMethodsCalls(Map<String, List<MethodDurationTuple>> methodStatistic) {
		Map<String, List<MethodDurationTuple>> testStatistic = new HashMap<String, List<MethodDurationTuple>>();
		
		for (String key : methodStatistic.keySet()) {
			List<MethodDurationTuple> value = methodStatistic.get(key);
			for (MethodDurationTuple tuple : value) {
				String thisTestName = getTestName();
				if (tuple.callingTest.equals(thisTestName)) {
					List<MethodDurationTuple> bmMethodCalls = testStatistic.get(key);
					if(bmMethodCalls==null){
						bmMethodCalls = new LinkedList<MethodDurationTuple>();
						bmMethodCalls.add(tuple);
						testStatistic.put(key, bmMethodCalls);       
					}else{
						bmMethodCalls.add(tuple);
					}                                
				}
			}
		}

		int totalMethodsCalls = 0;
		int uniqueMethodsCalls = 0;
		uniqueMethodsCalls += testStatistic.size();
		for(Entry<String, List<MethodDurationTuple>> metodCalls : testStatistic.entrySet()){
			totalMethodsCalls += metodCalls.getValue().size();
		}

		Map<String, String> result = new HashMap<String, String>();
		result.put("Number of BMs calls", String.valueOf(totalMethodsCalls));
		result.put("Number of unique BMs calls", String.valueOf(uniqueMethodsCalls));
		return result;
	}

	public TestReportChain getTestReport() {
		return testReport;
	}

	public abstract String getTestName();

	//	private void setTestReport(TestReportChain testReport) {
	//		testReport = testReport;
	//	}
}


