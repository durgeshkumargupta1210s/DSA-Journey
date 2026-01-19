class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> st = new Stack<>(); // {value, steps}
        int ans = 0;

        for (int x : nums) {
            int steps = 0;

            while (!st.isEmpty() && st.peek()[0] <= x) {
                steps = Math.max(steps, st.peek()[1]);
                st.pop();
            }

            if (!st.isEmpty()) steps++;

            ans = Math.max(ans, steps);
            st.push(new int[]{x, steps});
        }

        return ans;
    }
}