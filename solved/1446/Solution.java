class Solution {
    public int maxPower(String s) {
        int maxCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int tmpCnt = 1;
            while (i + 1 < s.length() && ch == s.charAt(i + 1)) {
                i++;
                tmpCnt++;
            }
            maxCnt = Math.max(maxCnt, tmpCnt);
        }
        return maxCnt;
    }
}