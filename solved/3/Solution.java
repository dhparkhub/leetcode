import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Character, Integer> map = new HashMap<>();

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= startIndex) {
                startIndex = map.get(ch) + 1;
            }
            map.put(ch, i);
            maxLength = Math.max(maxLength, i - startIndex + 1);
        }
        return maxLength;
    }
}