class Solution {
    public String minRemoveToMakeValid(String s) {
      return   removeParenthesis(s);
    }
    private static String removeParenthesis(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                st.push(i);
            } else if (sb.charAt(i) == ')') {
                if (!st.isEmpty() && sb.charAt(st.peek()) == '(') {
                    st.pop();
                } else {
                    st.push(i);  
                }
            }
        }

        
        while (!st.isEmpty()) {
            sb.deleteCharAt(st.pop());
        }

        return sb.toString();
    }

}