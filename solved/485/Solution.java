class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int tempCount = 0;
        for (int num : nums) {
            if (num == 0) {
                maxCount = Math.max(maxCount, tempCount);
                tempCount = 0;
                continue;
            }
            tempCount++;
        }
        return Math.max(maxCount, tempCount);
    }
}