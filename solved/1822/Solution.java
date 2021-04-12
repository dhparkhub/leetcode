class Solution {
    public int arraySign(int[] nums) {
        int minusCount = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) minusCount++;
        }
        return (minusCount % 2 == 0) ? 1 : -1;
    }
}