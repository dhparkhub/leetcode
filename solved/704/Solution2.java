class Solution {
    public int search(int[] nums, int target) {
        int targetIndex = binarySearch(nums, 0, nums.length - 1, target);
        return targetIndex >= 0 ? targetIndex : -1;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (target == nums[mid]) {
            return mid;
        }

        if (target < nums[mid]) {
            return binarySearch(nums, left, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, right, target);
        }
    }
}