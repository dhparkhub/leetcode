class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if (A[0] == B[0]) return minDominoRotations(A, B, A[0]);
        int x = minDominoRotations(A, B, A[0]);
        int y = minDominoRotations(B, A, B[0]);
        if (x == -1 || y == -1) return Math.max(x, y);
        return Math.min(x, y);
    }

    private int minDominoRotations(int[] A, int[] B, int target) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target && B[i] != target) return -1;
            if (A[i] != target) cnt1++;
            if (B[i] != target) cnt2++;
        }
        return Math.min(cnt1, cnt2);
    }
}