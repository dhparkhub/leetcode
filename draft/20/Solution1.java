import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    private static final Map<Character, Character> MAP = new HashMap<Character, Character>();
    static  {
        MAP.put(')', '(');
        MAP.put(']', '[');
        MAP.put('}', '{');
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) return false;
            if (stack.pop() != MAP.get(ch)) return false;
        }//O(N)

        return stack.isEmpty();
    }//O(N)
}