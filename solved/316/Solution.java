import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[indexOfChar(s.charAt(i))] = i;
        }

        boolean[] checked = new boolean[26];
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (checked[indexOfChar(ch)]) {
                continue;
            }

            while (!deque.isEmpty()) {
                char compCh = deque.peekLast();
                if (compCh > ch && i < lastIndex[indexOfChar(compCh)]) {
                    deque.removeLast();
                    checked[indexOfChar(compCh)] = false;
                    continue;
                }
                break;
            }

            deque.addLast(ch);
            checked[indexOfChar(ch)] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }

        return sb.toString();
    }

    private int indexOfChar(char ch) {
        return ch - 'a';
    }
}