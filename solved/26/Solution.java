import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Object> map = new HashMap<>();
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Object());
                i++;
                continue;
            }
            nums[i] = nums[--j];
        }
        Arrays.sort(nums, 0, j);
        return j;
    }
}