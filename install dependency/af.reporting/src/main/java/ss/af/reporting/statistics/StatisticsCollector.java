package ss.af.reporting.statistics;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StatisticsCollector {
    private final Map<String, List<MethodDurationTuple>> methodCalls;

    public StatisticsCollector() {
        methodCalls = new HashMap<String, List<MethodDurationTuple>>();
    }

    /**
     * Increments the method calls counter.
     *
     * @param methodShortSignature - Name of the declaring type.
     * @param callingTest        - Name of the method.
     * @param methodDuration    - Duration of the method.
     */
    public void incrementMethodCall(String methodShortSignature, String callingTest, long methodDuration) {
        if (!methodCalls.containsKey(methodShortSignature)) {
            methodCalls.put(methodShortSignature, new LinkedList<MethodDurationTuple>());
        }
        methodCalls.get(methodShortSignature).add(new MethodDurationTuple(callingTest, methodDuration));
    }

    public Map<String, List<MethodDurationTuple>> getMethodCallsStatistic() {
        return methodCalls;
    }

    public void clear() {
        methodCalls.clear();
    }

    public class MethodDurationTuple /*implements Comparable<MethodDurationTuple> */{
        public final String callingTest;
        public final long methodDuration;
        private final int prime = 31;

        public MethodDurationTuple(String callingTest, long methodDuration) {
            this.callingTest = callingTest;
            this.methodDuration = methodDuration;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result
                    + ((callingTest == null) ? 0 : callingTest.hashCode());
            result = prime * result
                    + (int) (methodDuration ^ (methodDuration >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MethodDurationTuple other = (MethodDurationTuple) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (callingTest == null) {
                if (other.callingTest != null)
                    return false;
            } else if (!callingTest.equals(other.callingTest))
                return false;
            return methodDuration == other.methodDuration;
        }

//        @Override
//        public int compareTo(MethodDurationTuple other) {
//            if (callingTest.equals(other.callingTest)) {
//                long x = methodDuration;
//                long y = other.methodDuration;
//                return (x < y) ? -1 : ((x == y) ? 0 : 1);
//            } else {
//                return callingTest.compareTo(other.callingTest);
//            }
//        }

        @Override
        public String toString() {
            return String.format("%s:%s", callingTest, String.valueOf(methodDuration));
        }

        private StatisticsCollector getOuterType() {
            return StatisticsCollector.this;
        }
    }
}

