class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String s = strs[0];
        for (int i = 0; i < s.length(); i++) {
            if (!hasSameChar(strs, i)) {
                return s.substring(0, i);
            }
        }//O(NL)
        return s;
    }//O(NL)

    private boolean hasSameChar(String[] strs, int index) {
        char ch = strs[0].charAt(index);
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            if (index >= s.length() || ch != s.charAt(index)) {
                return false;
            }
        }//O(N)
        return true;
    }//O(N)
}