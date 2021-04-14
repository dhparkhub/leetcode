class Solution {
    public int findTheWinner(int n, int k) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = (answer + k) % i;
        }
        return answer + 1;
    }
}