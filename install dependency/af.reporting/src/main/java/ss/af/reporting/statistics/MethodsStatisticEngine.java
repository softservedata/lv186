package ss.af.reporting.statistics;

import ss.af.reporting.statistics.StatisticsCollector.MethodDurationTuple;

import java.util.List;
import java.util.Map;

public interface MethodsStatisticEngine {
    int totalUniqueMethodCalls();

    int totalMethodCalls();

    Map<String, Integer> getTopReusedMethods(int count);

    /**
     * @return getTopReusedMethods(10)
     */
    Map<String, Integer> getTopReusedMethods();

    Map<String, Integer> getTopUnusedMethods(int count);

    /**
     * @return getTopUnusedMethods(10)
     */
    Map<String, Integer> getTopUnusedMethods();

    Map<String, Long> getTopTimeConsumingMethods(int count);

    /**
     * @return getTopTimeConsumingMethods(10)
     */
    Map<String, Long> getTopTimeConsumingMethods();

    Map<String, List<MethodDurationTuple>> getMethodsExecutionStatistic(int percent);

    /**
     * @return getMethodsExecutionStatistic(20)
     */
    Map<String, List<MethodDurationTuple>> getMethodsExecutionStatistic();
}
