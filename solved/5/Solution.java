class Solution {
    private String answer = "";

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            int remainMaxLen = (s.length() - i) * 2 + 1;
            if (remainMaxLen < answer.length()) break;
            palindromize(s, i, i);
            palindromize(s, i, i + 1);
        }
        return answer;
    }

    private void palindromize(String s, int i, int j) {
        if (i < 0) return;
        if (j >= s.length()) return;
        if (s.charAt(i) == s.charAt(j)) {
            int length = j - i + 1;
            if (length > answer.length()) {
                answer = s.substring(i, j + 1);
            }
            palindromize(s, i - 1, j + 1);
        }
    }
}