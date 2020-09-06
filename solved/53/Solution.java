class Solution {
    public int maxSubArray(int[] nums) {
        long maxSum = nums[0];
        long tempSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tempSum <= 0) {
                tempSum = nums[i];
            } else {
                tempSum += nums[i];
            }
            maxSum = Math.max(maxSum, tempSum);
        }// O(N)
        return (int) maxSum;
    }
}