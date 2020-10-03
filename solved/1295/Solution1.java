class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int temp = (int) Math.log10(num);
            if (temp % 2 == 1) {
                count++;
            }
        }
        return count++;
    }
}