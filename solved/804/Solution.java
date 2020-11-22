import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final String[] MORSE_CODES = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(stringToMorseCodes(word));
        }
        return set.size();
    }

    private String stringToMorseCodes(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(MORSE_CODES[ch - 'a']);
        }
        return sb.toString();
    }
}