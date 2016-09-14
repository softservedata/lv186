package ss.af.reporting;

/**
 * Represents enumeration of report details level.
 */
public enum ReportListenerLevel {
    /**
     * Writes all information to the report.
     */
    All,

    /**
     * Excludes verbose information from the report.
     */
    ExcludeVerbose,

    /**
     * Excludes log information from the report.
     */
    ExcludeLog,

    /**
     * Writes only validation information to the report.
     */
    OnlyValidations,

    /**
     * Writes only failed validations information to the report.
     */
    OnlyFailedValidations,

    /**
     * Writes only test results information to the report.
     */
    OnlyTestResults
}
