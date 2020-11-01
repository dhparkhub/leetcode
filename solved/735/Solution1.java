import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.add(asteroid);
                continue;
            }
            crush(stack, asteroid);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    private void crush(Stack<Integer> stack, int leftMoveAsteroid) {
        while (true) {
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.add(leftMoveAsteroid);
                return;
            }

            int rightMoveAsteroid = stack.peek();
            int crushed = rightMoveAsteroid + leftMoveAsteroid;
            if (crushed > 0) return;
            stack.pop();
            if (crushed == 0) return;
        }
    }
}