import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(ch);
                continue;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() != '[') {
                sb.append(stack.pop());
            }

            stack.pop();// remove '['

            StringBuilder sb2 = new StringBuilder();
            while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                sb2.append(stack.pop());
            }

            String generated = generate(sb.reverse().toString(), Integer.parseInt(sb2.reverse().toString()));
            for (char ch2 : generated.toCharArray()) {
                stack.push(ch2);
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }

    private String generate(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}