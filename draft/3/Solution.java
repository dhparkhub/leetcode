import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= startIndex) {
                startIndex = map.get(ch) + 1;
            }
            map.put(ch, i);
            answer = Math.max(answer, i - startIndex + 1);
        }// O(N)
        return answer;
    }// O(N)
}