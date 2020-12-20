import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        int answer = 0;
        int tempIdx = 0;
        int tempSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                tempSum += num;
            } else {
                tempIdx = Math.max(tempIdx, map.get(num));
                tempSum = sums[i] - sums[tempIdx];
            }
            map.put(num, i);
            answer = Math.max(answer, tempSum);
        }

        return answer;
    }
}