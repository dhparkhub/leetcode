import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map1.put(a + b, map1.getOrDefault(a + b, 0) + 1);
            }
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int c : C) {
            for (int d : D) {
                map2.put(c + d, map2.getOrDefault(c + d, 0) + 1);
            }
        }

        int answer = 0;
        for (Map.Entry<Integer, Integer> e : map1.entrySet()) {
            answer += e.getValue() * map2.getOrDefault(-e.getKey(), 0);
        }

        return answer;
    }
}