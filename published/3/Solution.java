import java.util.Arrays;

class Solution {
    private final int[] indexMap = new int[128];

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        Arrays.fill(indexMap, -1);

        int maxLength = 1;
        int startIndex = 0;
        char[] chArr = s.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            char ch = chArr[i];
            if (indexMap[ch] != -1 && indexMap[ch] >= startIndex) {
                startIndex = indexMap[ch] + 1;
            }
            indexMap[ch] = i;
            maxLength = Math.max(maxLength, i - startIndex + 1);
        }

        return maxLength;
    }
}