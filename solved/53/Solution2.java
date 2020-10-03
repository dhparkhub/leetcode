import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int pairCount = 0;
        for (Integer num : map.keySet()) {
            int pairNum = num + k;
            if (pairNum == num && map.get(num) >= 2) {
                pairCount++;
                continue;
            }
            if (pairNum != num && map.containsKey(pairNum)) {
                pairCount++;
            }
        }

        return pairCount;
    }
}