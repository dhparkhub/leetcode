class Solution {
    public int reverse(int x) {
        long reversed = 0;
        while (x != 0) {
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }//O(N)
        return isOutOfRange(reversed) ? 0 : (int) reversed;
    }//O(N)

    private boolean isOutOfRange(long num) {
        return num != (int) num;
    }//O(1)
}