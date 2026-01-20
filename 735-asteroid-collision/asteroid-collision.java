class Solution {

    // This method simulates asteroid collisions and
    // returns the final state after all collisions
    public int[] asteroidCollision(int[] ast) {

        // Stack to store asteroids that are still moving
        // Positive value  -> moving right
        // Negative value  -> moving left
        Stack<Integer> st = new Stack<>();

        // Traverse each asteroid
        for (int i = 0; i < ast.length; i++) {

            int val = ast[i];

            // Flag to check whether the current asteroid is destroyed
            boolean destroyed = false;

            // Collision occurs only when:
            // - the asteroid on stack is moving right (positive)
            // - the current asteroid is moving left (negative)
            while (!st.isEmpty() && st.peek() > 0 && val < 0) {

                // Case 1: Top asteroid is smaller than the incoming one
                // Top asteroid gets destroyed
                if (st.peek() < -val) {
                    st.pop();          // remove smaller asteroid
                }

                // Case 2: Both asteroids are of equal size
                // Both get destroyed
                else if (st.peek() == -val) {
                    st.pop();          // remove top asteroid
                    destroyed = true;  // incoming asteroid also destroyed
                    break;
                }

                // Case 3: Incoming asteroid is smaller
                // Incoming asteroid gets destroyed
                else {
                    destroyed = true;
                    break;
                }
            }

            // If the current asteroid survives all possible collisions,
            // push it onto the stack
            if (!destroyed) {
                st.push(val);
            }
        }

        // Convert the remaining asteroids in the stack to result array
        int[] result = new int[st.size()];

        // Stack pops in reverse order, so fill the array from the end
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}
