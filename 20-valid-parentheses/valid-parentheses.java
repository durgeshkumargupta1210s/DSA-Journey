class Solution {
    public boolean isValid(String s) {

        // Stack to store opening brackets
        Stack<Character> st = new Stack<>();

        // Traverse each character of the string
        for (char ch : s.toCharArray()) {

            // If the character is an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            else {
                // If a closing bracket is found and stack is empty,
                // there is no matching opening bracket
                if (st.isEmpty()) {
                    return false;
                }

                // Check whether the closing bracket matches the top of the stack
                if (
                    (ch == ')' && st.peek() != '(') ||
                    (ch == '}' && st.peek() != '{') ||
                    (ch == ']' && st.peek() != '[')
                ) {
                    return false;
                }

                // If matched, remove the opening bracket from the stack
                st.pop();
            }
        }

        // If stack is empty, all brackets were properly matched
        return st.isEmpty();
    }
}
