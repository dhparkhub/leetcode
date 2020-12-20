class Solution {
    public int maxResult(int[] nums, int k) {
        return getScore(nums, k, 0, new Integer[nums.length]);
    }

    private int getScore(int[] nums, int k, int index, Integer[] cache) {
        if (index == nums.length - 1) return nums[index];
        if (cache[index] != null) return cache[index];
        int maxMinus = Integer.MIN_VALUE;
        int maxMinusIndex = 0;
        for (int i = index + 1; i <= index + k && i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] >= 0) {
                return cache[index] = nums[index] + getScore(nums, k, i, cache);
            }
            if (nums[i] > maxMinus) {
                maxMinus = nums[i];
                maxMinusIndex = i;
            }
        }
        return cache[index] = nums[index] + getScore(nums, k, maxMinusIndex, cache);
    }
}