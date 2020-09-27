import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);// O(NlogN)

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // prevent from duplication case
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 1; j++) {
                // prevent from duplication case
                if (j - 1 >= i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int twoSum = nums[i] + nums[j];
                int tempIndex = Arrays.binarySearch(nums, j + 1, nums.length, -twoSum);
                if (tempIndex >= 0) {
                    answer.add(Arrays.asList(nums[i], nums[j], -twoSum));// O(logN)
                }
            }
        }// O(N^2logN)

        return answer;
    }
}
