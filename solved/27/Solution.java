class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] != val) {
                i++;
                continue;
            }
            nums[i] = nums[--j];
        }
        return j;
    }
}