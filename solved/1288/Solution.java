import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);// O(NlogN)

        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                int[] tempInterval = intervals[j];
                if (tempInterval[0] >= interval[0] && tempInterval[1] <= interval[1]) {
                    i++;
                    continue;
                }
                break;
            }
            count++;
        }// O(N)

        return count;
    }
}