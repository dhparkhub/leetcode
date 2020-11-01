class Solution {
    private String answer = "";

    public String longestPalindrome(String s) {
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            // 남은 문자열로 만들 수 있는 Palindrome의 최대 길이가 정답보다 작다면 중지
            int remainMaxLen = (sLen - i) * 2 + 1;
            if (remainMaxLen < answer.length()) {
                break;
            }
            bruteForce(s, i, i);
            bruteForce(s, i, i + 1);
        }
        return answer;
    }

    private void bruteForce(String s, int i, int j) {
        if (i < 0 || j >= s.length()) {
            return;
        }
        if (s.charAt(i) == s.charAt(j)) {
            // 정답보다 클 때만 문자열을 갱신
            int tmpLen = j - i + 1;
            if (tmpLen > answer.length()) {
                answer = s.substring(i, j + 1);
            }
            bruteForce(s, i - 1, j + 1);
        }
    }
}