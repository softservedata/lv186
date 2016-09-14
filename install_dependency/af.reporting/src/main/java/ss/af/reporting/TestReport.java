package ss.af.reporting;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Defines methods for reporting Test Runs specific information.
 */
public interface TestReport {

    /**
     * Setups the test run's report.
     *
     * @param level - The report listener level.
     */
    void setup(ReportListenerLevel level);

    /**
     * Setups the test run's report.
     *
     * @param level                - The report listener level.
     * @param testStartRunMetadata - Test run's start metadata.
     */
    void setup(ReportListenerLevel level, Map<String, String> testStartRunMetadata);

    /**
     * Closes the test run's report.
     *
     * @param testEndRunMetadata - The test end run metadata.
     */
    void closeReport(Map<String, String> testEndRunMetadata);

    /**
     * Closes the test run's report.
     */
    void closeReport();

    /**
     * Logs the message as verbose data.
     *
     * @param message - The message.
     * @param args  - The arguments.
     */
    void logVerbose(String message, Object... args);

    /**
     * Logs the message as information.
     *
     * @param message - The message.
     * @param args  - The arguments.
     */
    void logInfo(String message, Object... args);

    /**
     * Logs the message as warning.
     *
     * @param message - The message.
     * @param args  - The arguments.
     */
    void logWarning(String message, Object... args);

    /**
     * Logs the message as error.
     *
     * @param message - The message.
     * @param args  - The arguments.
     */
    void logError(String message, Object... args);

    /**
     * Logs the image.
     *
     * @param image - The image.
     */
    void logImage(BufferedImage image);

    /**
     * Writes the validation result.
     *
     * @param result  - if set to true validation succeeded, otherwise it failed.
     * @param message - The message.
     * @param args  - The arguments.
     */
    void writeValidationResult(boolean result, String message, Object... args);

    /**
     * Writes the test result.
     *
     * @param result  - if set to <true test succeeded, otherwise it failed.
     * @param message - The message.
     * @param args  - The arguments.
     */
    void writeTestResult(boolean result, String message, Object... args);

    /**
     * Writes the execution information.
     *
     * @param infoName   - Name of the information.
     * @param attributes - The attributes.
     */
    void writeExecutionInfo(String infoName, Map<String, String> attributes);
}
