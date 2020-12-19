class Solution {
    public boolean increasingTriplet(int[] nums) {
        Integer x = null;
        Integer y = null;
        for (int num : nums) {
            if (x == null || num < x) {
                x = num;
                continue;
            }
            if (num == x) continue;
            if (y == null || num < y) {
                y = num;
                continue;
            }
            if (num > y) return true;
        }// O(N)
        return false;
    }// O(N)
}