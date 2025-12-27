class Solution {
    public String resultingString(String s) {

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (stack.length() > 0) {
                char top = stack.charAt(stack.length() - 1);
                int diff = Math.abs(top - ch);

                if (diff == 1 || diff == 25) {
                    stack.deleteCharAt(stack.length() - 1); 
                    continue;
                }
            }

            stack.append(ch);
        }

        return stack.toString();
    }
}
