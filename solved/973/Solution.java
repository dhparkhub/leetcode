import java.util.Arrays;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (o1, o2) -> {
            int x = o1[0] * o1[0] + o1[1] * o1[1];
            int y = o2[0] * o2[0] + o2[1] * o2[1];
            return Integer.compare(x, y);
        });//O(NlogN)

        int[][] answer = new int[K][2];
        for (int i = 0; i < K; i++) {
            answer[i][0] = points[i][0];
            answer[i][1] = points[i][1];
        }//O(K)

        return answer;
    }//O(NlogN)
}