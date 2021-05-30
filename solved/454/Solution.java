import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }// O(N^2)
        int answer = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                answer += map.getOrDefault(-(i + j), 0);
            }
        }// O(N^2)
        return answer;
    }// O(N^2)
}