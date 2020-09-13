import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private final LinkedList<List<Integer>> mergedIntervals = new LinkedList<>();

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(Arrays.asList(start, end));
                continue;
            }

            List<Integer> lastInterval = mergedIntervals.removeLast();
            int nStart = lastInterval.get(0);
            int nEnd = lastInterval.get(1);
            if (start <= nEnd) {
                nEnd = Math.max(nEnd, end);
                mergedIntervals.add(Arrays.asList(nStart, nEnd));
                continue;
            }

            mergedIntervals.add(lastInterval);
            mergedIntervals.add(Arrays.asList(start, end));
        }

        int[][] answer = new int[mergedIntervals.size()][];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            answer[i] = new int[]{mergedIntervals.get(i).get(0), mergedIntervals.get(i).get(1)};
        }
        return answer;
    }
}