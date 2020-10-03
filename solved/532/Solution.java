import java.util.Arrays;

class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);// O(NlogN)

        int pairsCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int pairIndex = Arrays.binarySearch(nums, i + 1, nums.length, nums[i] + k);
            if (pairIndex >= 0) {
                pairsCount++;
            }
        }// O(NlogN)

        return pairsCount;
    }
}