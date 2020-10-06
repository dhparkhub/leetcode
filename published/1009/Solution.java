class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int answer;
        int log2N = (int) (Math.log(N) / Math.log(2));// log2(N)
        if (Math.pow(2, log2N) == N) {
            answer = N - 1;
        } else {
            answer = (int) Math.pow(2, log2N + 1);
            answer = answer - N - 1;
        }
        return answer;
    }
}