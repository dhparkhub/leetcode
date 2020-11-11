import java.util.Arrays;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (isSamePoint(p1, p2)) return false;
        if (isSamePoint(p1, p3)) return false;
        if (isSamePoint(p1, p4)) return false;
        if (isSamePoint(p2, p3)) return false;
        if (isSamePoint(p2, p4)) return false;
        if (isSamePoint(p3, p4)) return false;
        boolean case1 = isSquare(new int[]{distance(p1, p2), distance(p1, p3), distance(p1, p4)});
        boolean case2 = isSquare(new int[]{distance(p2, p1), distance(p2, p3), distance(p2, p4)});
        boolean case3 = isSquare(new int[]{distance(p3, p1), distance(p3, p2), distance(p3, p4)});
        boolean case4 = isSquare(new int[]{distance(p4, p1), distance(p4, p2), distance(p4, p3)});
        return case1 && case2 && case3 && case4;
    }

    private boolean isSamePoint(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    private int distance(int[] p1, int[] p2) {
        int x = (p1[0] - p2[0]) * (p1[0] - p2[0]);
        int y = (p1[1] - p2[1]) * (p1[1] - p2[1]);
        return x + y;
    }

    private boolean isSquare(int[] distances) {
        Arrays.sort(distances);
        return distances[0] == distances[1] && distances[0] + distances[1] == distances[2];
    }
}