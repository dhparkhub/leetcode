import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        LinkedList<List<Integer>> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            merge(merged, interval);
        }

        int[][] answer = new int[merged.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new int[]{merged.get(i).get(0), merged.get(i).get(1)};
        }
        return answer;
    }

    private void merge(LinkedList<List<Integer>> merged, int[] interval) {
        if (merged.isEmpty()) {
            merged.add(Arrays.asList(interval[0], interval[1]));
            return;
        }

        List<Integer> last = merged.removeLast();
        if (interval[0] <= last.get(1)) {
            merged.add(Arrays.asList(last.get(0), Math.max(last.get(1), interval[1])));
            return;
        }

        merged.add(last);
        merged.add(Arrays.asList(interval[0], interval[1]));
    }
}