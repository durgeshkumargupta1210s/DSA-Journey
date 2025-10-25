import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                int top = stack.peek();

                if (top < -ast) {
                    stack.pop(); // top asteroid explodes, continue checking
                } else if (top == -ast) {
                    stack.pop(); // both explode
                    destroyed = true;
                    break;
                } else {
                    // current asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
