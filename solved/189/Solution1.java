import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) return;

        k %= nums.length;
        if (k == 0) return;

        int[] kArr = Arrays.copyOf(nums, k);
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % nums.length;
            int temp = nums[index];
            nums[index] = kArr[i % k];
            kArr[i % k] = temp;
        }
    }
}