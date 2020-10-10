import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (Comparator.comparingInt(o -> o[1])));

        int shots = 0;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] compPoint = points[j];
                if (compPoint[0] > point[1]) {
                    break;
                }
                i++;
            }
            shots++;
        }

        return shots;
    }
}