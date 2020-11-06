import java.util.Arrays;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = 1000000;
        while (l < r) {
            int m = (l + r) / 2;
            int temp = getQuotientSum(nums, m);
            if (temp <= threshold) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private int getQuotientSum(int[] nums, int divisor) {
        return Arrays.stream(nums)
                .map(i -> (i + divisor - 1) / divisor)
                .sum();
    }
}