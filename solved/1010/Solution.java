class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        for (int t : time) {
            arr[t % 60]++;
        }
        int answer = 0;
        answer += (arr[0] * (arr[0] - 1)) / 2;
        answer += (arr[30] * (arr[30] - 1)) / 2;
        for (int i = 1; i <= 29; i++) {
            answer += arr[i] * arr[60 - i];
        }
        return answer;
    }
}