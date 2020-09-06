import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Character, Integer> orderMap = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1])) {
                return false
            }
        }
        return true;
    }

    private boolean compare(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLen; i++) {
            int temp = orderMap.get(s1.charAt(i)) - orderMap.get(s2.charAt(i));
            if (temp < 0) return true;
            if (temp == 0) continue;
            return false;
        }
        return s1.length() <= s2.length();
    }
}