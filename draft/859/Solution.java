class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        int[] diff = new int[]{-1, -1};
        int[] k = new int[26];
        int maxK = 0;
        for (int i = 0; i < A.length(); i++) {
            char ch1 = A.charAt(i);
            k[ch1 - 'a']++;
            maxK = Math.max(maxK, k[ch1 - 'a']);

            char ch2 = B.charAt(i);
            if (ch1 != ch2) {
                if (diff[0] == -1) {
                    diff[0] = i;
                    continue;
                } else if (diff[1] == -1) {
                    diff[1] = i;
                    continue;
                }
                return false;
            }
        }

        if (diff[0] == diff[1]) return maxK >= 2;
        if (diff[1] == -1) return false;
        return A.charAt(diff[0]) == B.charAt(diff[1]) && A.charAt(diff[1]) == B.charAt(diff[0]);
    }
}