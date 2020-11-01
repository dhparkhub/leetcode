import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        int targetIndex = Arrays.binarySearch(nums, target);
        return targetIndex >= 0 ? targetIndex : -1;
    }
}