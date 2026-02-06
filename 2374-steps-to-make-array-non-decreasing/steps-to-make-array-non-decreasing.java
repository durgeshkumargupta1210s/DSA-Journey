class Solution {

    /*
     * Function: totalSteps
     * --------------------
     * Returns the number of steps required to make the array non-decreasing.
     *
     * Problem Rule:
     * In each step, remove all elements nums[i] where nums[i] < nums[i-1].
     * We must count how many such rounds are needed.
     *
     * Approach: Monotonic Stack
     *
     * We use a stack where each element stores:
     * {value, steps_required_to_remove_this_element}
     *
     * Stack maintains a MONOTONIC DECREASING ORDER from bottom to top.
     *
     * Why stack works:
     * - When current element is greater than stack top,
     *   it can cause removal chain reactions.
     * - We calculate how many rounds current element survives.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public int totalSteps(int[] nums) {

        // Stack stores pair: {element value, steps required to remove it}
        Stack<int[]> st = new Stack<>();

        // Stores maximum steps required to make entire array non-decreasing
        int ans = 0;

        // Traverse array from left to right
        for (int ele : nums) {

            // Steps required for current element
            int step = 0;

            /*
             * Remove all smaller or equal elements from stack
             *
             * Reason:
             * - If stack top <= current element,
             *   stack top cannot remove current element.
             * - Instead, current element survives longer.
             *
             * We also propagate maximum steps from popped elements.
             */
            while (!st.isEmpty() && st.peek()[0] <= ele) {

                // Take maximum steps among popped elements
                step = Math.max(step, st.peek()[1]);

                // Remove element from stack
                st.pop();
            }

            /*
             * If stack is not empty after popping,
             * it means there exists a greater element on left.
             *
             * So current element will be removed in next step.
             */
            if (!st.isEmpty()) {
                step++;
            }

            /*
             * Update global maximum steps
             */
            ans = Math.max(ans, step);

            /*
             * Push current element and its step count into stack
             */
            st.push(new int[]{ele, step});
        }

        /*
         * Return total steps required
         */
        return ans;
    }
}
