package ss.af.reporting.statistics;

import ss.af.reporting.statistics.StatisticsCollector.MethodDurationTuple;

import java.util.*;
import java.util.Map.Entry;

public class MethodsStatisticEngineImpl implements MethodsStatisticEngine {
    private static final String AVERAGE_DURATION = "avgExec";
    private static final String LONG_AVERAGE_DURATION = "longAvgExec";
    private static final String SHORT_AVERAGE_DURATION = "shortAvgExec";
    private static final String TOTAL_EXECUTION = "totalExec";
    private static final String CALL_COUNT = "callCount";

    private final Map<String, List<MethodDurationTuple>> methodStatistic;
    private static StatisticsCollector statisticsCollector;

    public MethodsStatisticEngineImpl(Map<String, List<MethodDurationTuple>> methodStatistic) {
        this.methodStatistic = methodStatistic;
        statisticsCollector = new StatisticsCollector();
    }

    public int totalUniqueMethodCalls() {
        return methodStatistic.keySet().size();
    }

    public int totalMethodCalls() {
        int methodCalls = 0;
        for (Entry<String, List<MethodDurationTuple>> entry : methodStatistic.entrySet()) {
            methodCalls += entry.getValue().size();
        }
        return methodCalls;
    }

    public Map<String, Integer> getTopReusedMethods(int count) {
        Map<String, Integer> topReusedMethods = new HashMap<String, Integer>();
        for (Entry<String, List<MethodDurationTuple>> entry : methodStatistic.entrySet()) {
            topReusedMethods.put(entry.getKey(), entry.getValue().size());
        }
        return sortAndTrimByValue(topReusedMethods, count, false);
    }

    public Map<String, Integer> getTopReusedMethods() {
        return getTopReusedMethods(10);
    }

    public Map<String, Integer> getTopUnusedMethods(int count) {
        Map<String, Integer> topUnusedMethods = new HashMap<String, Integer>();
        for (Entry<String, List<MethodDurationTuple>> entry : methodStatistic.entrySet()) {
            topUnusedMethods.put(entry.getKey(), entry.getValue().size());
        }
        return sortAndTrimByValue(topUnusedMethods, count);
    }

    public Map<String, Integer> getTopUnusedMethods() {
        return getTopUnusedMethods(10);
    }

    public Map<String, Long> getTopTimeConsumingMethods(int count) {
        Map<String, Long> topTimeConsumingMethods = new HashMap<String, Long>();
        for (Entry<String, List<MethodDurationTuple>> entry : methodStatistic.entrySet()) {
            List<MethodDurationTuple> value = entry.getValue();
			MethodDurationTuple max = Collections.max(value,new TupleDurationComparator());
            topTimeConsumingMethods.put(entry.getKey(), max.methodDuration);
        }
        return sortAndTrimByValue(topTimeConsumingMethods, count, false);
    }

    public Map<String, Long> getTopTimeConsumingMethods() {
        return getTopTimeConsumingMethods(10);
    }

    public Map<String, List<MethodDurationTuple>> getMethodsExecutionStatistic(int percent) {
        int methodCount = getPercentageCount(methodStatistic.size(), percent);
        List<MethodDurationTuple> mostTimeConsumingMethodsList = new LinkedList<MethodDurationTuple>();
        for (Entry<String, List<MethodDurationTuple>> entry : methodStatistic.entrySet()) {
            long duration = 0;
            for (MethodDurationTuple run : entry.getValue()) {
                duration += run.methodDuration;
            }
            mostTimeConsumingMethodsList.add(statisticsCollector.new MethodDurationTuple(entry.getKey(), duration));
        }
		Collections.sort(mostTimeConsumingMethodsList, Collections.reverseOrder(new TupleDurationComparator()));
//		List<String> mostTimeConsumingMethods = new ArrayList<String>(methodStatistic.size());

        Map<String, List<MethodDurationTuple>> statistic = new HashMap<String, List<MethodDurationTuple>>();

        for (MethodDurationTuple mdt : mostTimeConsumingMethodsList.subList(0, methodCount)) {
            String methodSig = mdt.callingTest;
            List<MethodDurationTuple> stats = calculateMethodStatistic(methodStatistic.get(methodSig));
            statistic.put(methodSig, stats);
        }
        return statistic;
    }

    public Map<String, List<MethodDurationTuple>> getMethodsExecutionStatistic() {
        return getMethodsExecutionStatistic(20);
    }

    private static List<MethodDurationTuple> calculateMethodStatistic(List<MethodDurationTuple> methodDurations) {
        int persent = 20;

        int durationCount = getPercentageCount(methodDurations.size(), persent);

        long totalExecution = 0;//methodDurations.Sum(i => i.Item2);
        int longestDurationSum = 0;
        int shortestDurationSum = 0;

	    Collections.sort(methodDurations,new TupleDurationComparator());

        for (MethodDurationTuple entry : methodDurations) {
            totalExecution += entry.methodDuration;
        }
        for (MethodDurationTuple entry : methodDurations.subList(0, durationCount)) {
            shortestDurationSum += entry.methodDuration;
        }
        for (MethodDurationTuple entry : methodDurations.subList(methodDurations.size() - durationCount, methodDurations.size())) {
            longestDurationSum += entry.methodDuration;
        }

        //Longest avr run
        int longestAverage = longestDurationSum / durationCount;//methodDurations.OrderByDescending(i => i.Item2).Take(durationCount).Sum(md => md.Item2) / durationCount;
        //Shortest avr run
        int shortestAverage = shortestDurationSum / durationCount;//methodDurations.OrderBy(i => i.Item2).Take(durationCount).Sum(md => md.Item2) / durationCount;
        long averageDuration = totalExecution / methodDurations.size();

        List<MethodDurationTuple> result = new LinkedList<MethodDurationTuple>();
        result.add(statisticsCollector.new MethodDurationTuple(CALL_COUNT, methodDurations.size()));
        result.add(statisticsCollector.new MethodDurationTuple(TOTAL_EXECUTION, totalExecution));
        result.add(statisticsCollector.new MethodDurationTuple(AVERAGE_DURATION, averageDuration));
        result.add(statisticsCollector.new MethodDurationTuple(LONG_AVERAGE_DURATION, longestAverage));
        result.add(statisticsCollector.new MethodDurationTuple(SHORT_AVERAGE_DURATION, shortestAverage));
        return result;
    }

    private static int getPercentageCount(int count, int percent) {
        int percentageCount = (int) Math.round(count * (((double) percent) / 100));
        if (percentageCount < 1) {
            percentageCount = 1;
        }
        return percentageCount;
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortAndTrimByValue(Map<K, V> unsortedMap, int count, boolean ascending) {
        List<Entry<K, V>> list = new LinkedList<Entry<K, V>>(unsortedMap.entrySet());

        Comparator<Entry<K, V>> comparator = new Comparator<Entry<K, V>>() {
            public int compare(Entry<K, V> one, Entry<K, V> another) {
                return one.getValue().compareTo(another.getValue());
            }
        };

        if (ascending) {
            Collections.sort(list, comparator);
        } else {
            Collections.sort(list, Collections.reverseOrder(comparator));
        }

        Map<K, V> sortedMap = new LinkedHashMap<K, V>();

        int i = 0;
        for (Iterator<Entry<K, V>> it = list.iterator(); it.hasNext() && i < count; ) {
            Entry<K, V> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
            i++;
        }
        return sortedMap;
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortAndTrimByValue(Map<K, V> unsortedMap, int count) {
        return sortAndTrimByValue(unsortedMap, count, true);
    }
}
class TupleDurationComparator implements Comparator<MethodDurationTuple>{
	@Override
	public int compare(MethodDurationTuple o1, MethodDurationTuple o2) {
		Long o1Time = new Long(o1.methodDuration);
		return o1Time.compareTo(o2.methodDuration) ;
	}
}
