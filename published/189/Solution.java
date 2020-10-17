import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) return;

        k %= nums.length;
        if (k == 0) return;

        int[] copied = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = copied[(i - k + nums.length) % nums.length];
        }
    }
}