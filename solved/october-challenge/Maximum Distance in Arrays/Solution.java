import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int answer = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);

            if (i == 0) {
                minVal = list.get(0);
                maxVal = list.get(list.size() - 1);
                continue;
            }

            int x = Math.abs(minVal - list.get(list.size() - 1));
            int y = Math.abs(maxVal - list.get(0));
            answer = Math.max(answer, Math.max(x, y));

            minVal = Math.min(minVal, list.get(0));
            maxVal = Math.max(maxVal, list.get(list.size() - 1));
        }
        return answer;
    }
}