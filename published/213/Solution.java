import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] cache = new int[nums.length];

        Arrays.fill(cache, -1);
        int case1 = rob(cache, nums, 0, nums.length - 1);// without last house

        Arrays.fill(cache, -1);
        int case2 = rob(cache, nums, 1, nums.length);// without first house

        return Math.max(case1, case2);
    }

    private int rob(int[] cache, int[] nums, int index, int maxIndex) {
        if (index >= maxIndex) return 0;
        if (cache[index] != -1) return cache[index];
        int case1 = nums[index] + rob(cache, nums, index + 2, maxIndex);
        int case2 = rob(cache, nums, index + 1, maxIndex);
        return cache[index] = Math.max(case1, case2);
    }
}
