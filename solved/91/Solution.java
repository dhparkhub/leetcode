class Solution {
    public int numDecodings(String s) {
        return dp(s, 0, new Integer[s.length()]);
    }

    private int dp(String s, int index, Integer[] dp) {
        if (index == s.length()) return 1;
        if (dp[index] != null) return dp[index];

        dp[index] = 0;

        int num = s.charAt(index) - '0';
        if (!canDecoded(num)) return dp[index];
        dp[index] += dp(s, index + 1, dp);

        if (index >= s.length() - 1) return dp[index];

        num = num * 10 + (s.charAt(index + 1) - '0');
        if (!canDecoded(num)) return dp[index];

        return dp[index] += dp(s, index + 2, dp);
    }

    private boolean canDecoded(int i) {
        return i >= 1 && i <= 26;
    }
}