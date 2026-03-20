class Solution {
    public int longestValidParentheses(String s) {

        // Convert string to char array for faster access
        char[] arr = s.toCharArray();

        // Stack to store indices (NOT characters)
        Stack<Integer> st = new Stack<>();

        // Push -1 as a base index
        // This helps in calculating length when valid substring starts from index 0
        st.push(-1);

        int ans = 0; // Stores maximum length of valid parentheses

        // Traverse the string
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '(') {
                // Push index of opening bracket
                st.push(i);
            } else {
                // Found closing bracket → try to match with previous '('
                st.pop();

                if (st.isEmpty()) {
                    // No matching '(' available
                    // Push current index as new base
                    st.push(i);
                } else {
                    // Valid substring found
                    // Length = current index - last unmatched index
                    int length = i - st.peek();

                    // Update maximum length
                    ans = Math.max(ans, length);
                }
            }
        }

        // Return longest valid parentheses substring length
        return ans;
    }
}