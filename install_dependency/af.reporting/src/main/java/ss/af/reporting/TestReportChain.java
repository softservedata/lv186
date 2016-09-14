package ss.af.reporting;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestReportChain implements TestReport {
	protected final List<TestReport> reports = new LinkedList<TestReport>();

	/**
	 * Adds the report.
	 *
	 * @param report - The report.
	 */
	public void addReport(TestReport report) {
		reports.add(report);
	}

	/**
	 * Setups the test run's report.
	 *
	 * @param level                - The report listener level.
	 * @param testStartRunMetadata - Test run's start metadata.
	 */
	public void setup(ReportListenerLevel level, Map<String, String> testStartRunMetadata) {
		for (TestReport report : reports) {
			report.setup(level, testStartRunMetadata);
		}
	}

	/**
	 * Setups the test run's report with testStartRunMetadata = null.
	 *
	 * @param level - The report listener level.
	 */
	public void setup(ReportListenerLevel level) {
		setup(level, null);
	}

	/**
	 * Closes the test run's report.
	 *
	 * @param testEndRunMetadata - The test end run metadata.
	 */
	public void closeReport(Map<String, String> testEndRunMetadata) {
		for (TestReport report : reports) {
			if (report instanceof SuiteReport) {
				continue;
			}
			report.closeReport(testEndRunMetadata);
		}
		for (TestReport report : reports) {
			if (!(report instanceof SuiteReport)) {
				continue;
			}
			report.closeReport(testEndRunMetadata);
		}
		reports.clear();
	}

	/**
	 * Closes the test run's report with testEndRunMetadata = null.
	 */
	public void closeReport() {
		closeReport(null);
	}

	/**
	 * Logs the message as verbose data.
	 *
	 * @param message - The message.
	 * @param args  - The arguments.
	 */
	public void logVerbose(String message, Object... args) {
		for (TestReport report : reports) {
			report.logVerbose(message, args);
		}
	}

	/**
	 * Logs the message as information.
	 *
	 * @param message - The message.
	 * @param args  - The arguments.
	 */
	public void logInfo(String message, Object... args) {
		for (TestReport report : reports) {
			report.logInfo(message, args);
		}
	}

	/**
	 * Logs the message as warning.
	 *
	 * @param message - The message.
	 * @param args  - The arguments.
	 */
	public void logWarning(String message, Object... args) {
		for (TestReport report : reports) {
			report.logWarning(message, args);
		}
	}

	/**
	 * Logs the message as error.
	 *
	 * @param message - The message.
	 * @param args  - The arguments.
	 */
	public void logError(String message, Object... args) {
		for (TestReport report : reports) {
			report.logError(message, args);
		}
	}

	/**
	 * Logs the image.
	 *
	 * @param image
	 */
	public void logImage(BufferedImage image) {
		for (TestReport report : reports) {
			report.logImage(image);
		}
	}

	/**
	 * Writes the validation result.
	 *
	 * @param result - if set to true validation succeeded, otherwise it failed.
	 * @param message - message.
	 * @param args    - arguments.
	 */
	public void writeValidationResult(boolean result, String message, Object... args) {
		for (TestReport report : reports) {
			report.writeValidationResult(result, message, args);
		}
	}

	/**
	 * Writes the test result.
	 *
	 * @param result - if set to true validation succeeded, otherwise it failed.
	 * @param message - message.
	 * @param args    - arguments.
	 */
	public void writeTestResult(boolean result, String message, Object... args) {
		for (TestReport report : reports) {
			report.writeTestResult(result, message, args);
		}
	}

	/**
	 * Writes the execution information.
	 *
	 * @param infoName   - Name of the information.
	 * @param attributes - The attributes.
	 */
	public void writeExecutionInfo(String infoName, Map<String, String> attributes) {
		for (TestReport report : reports) {
			report.writeExecutionInfo(infoName, attributes);
		}
	}

	protected Map<String, String> mergeRuntimeData(Map<String, String> dataFirst, Map<String, String> dataSecond) {
		if (dataSecond == null) {
			return dataFirst;
		}
		if (dataFirst == null) {
			return dataSecond;
		}
		//	<C#>
		//		dataFirst.Concat(dataSecond).GroupBy(d => d.Key).ToDictionary(d => d.Key, d => d.Last().Value);
		//	</C#>
		HashMap<String, String> merged = new HashMap<String, String>();
		merged.putAll(dataFirst);
		merged.putAll(dataSecond);
		return merged;
	}
}

