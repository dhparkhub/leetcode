import java.util.Arrays;

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == target;

        // ascending case
        if (nums[0] < nums[nums.length - 1]) {
            int index = Arrays.binarySearch(nums, 0, nums.length, target);// O(logN)
            return index >= 0;
        }

        // find minimum number's index
        int i = 0;
        int j = nums.length - 1;
        int minIndex = -1;
        while (i <= j) {
            if (nums[i] == target) return true;
            if (nums[j] == target) return true;
            if (i - 1 >= 0 && nums[i - 1] > nums[i]) {
                minIndex = i;
                break;
            }
            if (j + 1 < nums.length && nums[j + 1] < nums[j]) {
                minIndex = j + 1;
                break;
            }
            i++;
            j--;
        }

        if (minIndex == i) {
            return Arrays.binarySearch(nums, i, j, target) >= 0;
        }
        if (minIndex == j + 1) {
            return Arrays.binarySearch(nums, i + 1, j + 1, target) >= 0;
        }

        return false;
    }
}
