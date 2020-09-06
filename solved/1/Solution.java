import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }// O(N)
        return null;
    }
}