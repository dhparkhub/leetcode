class Solution {
    public int reverse(int x) {
        long reversed = 0;
        while (x != 0) {
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }

        // overflow
        if (reversed != (int) reversed) {
            return 0;
        }

        return (int) reversed;
    }
}