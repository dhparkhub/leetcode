class Solution {
    public int bitwiseComplement(int N) {
        int bitMast = 1;
        while ((N & bitMast) != N) {
            bitMast = (bitMast << 1) | 1;
        }
        return N ^ bitMast;
    }
}