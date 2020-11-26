class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        int temp = 0;
        for (int i=1; ;i++) {
            temp = (temp * 10 + 1) % K;
            if (temp == 0) return i;
        }
    }
}