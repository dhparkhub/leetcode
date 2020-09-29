import java.util.Stack;

class Solution {
    private final Stack<Object> stack = new Stack<>();

    public int minOperations(String[] logs) {
        for (String log : logs) {
            if ("./".equals(log)) {
                continue;
            }
            if ("../".equals(log)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(new Object());
        }
        return stack.size();
    }
}