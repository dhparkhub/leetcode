import java.util.Stack;

class Solution {
    private final Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty() || !isValid(stack.pop(), ch)) {
                return false;
            }
        }// O(N)

        return stack.isEmpty();// check if open character remains
    }// O(N)

    private boolean isValid(char open, char close) {
        if (open == '(' && close == ')') return true;
        if (open == '{' && close == '}') return true;
        if (open == '[' && close == ']') return true;
        return false;
    }
}