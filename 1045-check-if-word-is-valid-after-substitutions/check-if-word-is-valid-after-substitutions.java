class Solution {
    public boolean isValid(String s) {

        // Stack to store characters while processing the string
        Stack<Character> st = new Stack<>();

        // Traverse each character in the string
        for (char ch : s.toCharArray()) {

            // Push current character onto the stack
            st.push(ch);

            // Check only when stack has at least 3 characters
            // because we are looking for the pattern "abc"
            if (st.size() >= 3) {

                int n = st.size();

                // Check if the top three characters form "abc"
                if (st.get(n - 3) == 'a' &&
                    st.get(n - 2) == 'b' &&
                    st.get(n - 1) == 'c') {

                    // Remove "abc" from the stack
                    st.pop(); // removes 'c'
                    st.pop(); // removes 'b'
                    st.pop(); // removes 'a'
                }
            }
        }

        // If stack is empty, all "abc" patterns were successfully removed
        return st.isEmpty();
    }
}
