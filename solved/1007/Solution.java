class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int answer = Integer.MAX_VALUE;
        int a = minDominoRotations(A, B, A[0]);
        int b = minDominoRotations(A, B, B[0]);
        int c = minDominoRotations(B, A, A[0]);
        int d = minDominoRotations(B, A, B[0]);
        if (a != -1) answer = Math.min(answer, a);
        if (b != -1) answer = Math.min(answer, b);
        if (c != -1) answer = Math.min(answer, c);
        if (d != -1) answer = Math.min(answer, d);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int minDominoRotations(int[] A, int[] B, int target) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) continue;
            if (B[i] == target) {
                count++;
                continue;
            }
            return -1;
        }
        return count;
    }
}