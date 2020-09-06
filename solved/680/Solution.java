class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, false);
    }

    private boolean validPalindrome(String s, boolean cheat) {
        for (int i = 0; i < s.length() / 2; i++) {
            int j = s.length() - i - 1;
            if (s.charAt(i) != s.charAt(j)) {
                if (cheat) return false;
                boolean case1 = validPalindrome(s.substring(i + 1, j + 1), true);
                boolean case2 = validPalindrome(s.substring(i, j), true);
                return case1 || case2;
            }
        }
        return true;
    }
}