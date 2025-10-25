import java.util.Stack;

class Solution {
    static class Pair {
        char c;
        int count;
        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c) {
                stack.peek().count++;
            } else {
                stack.push(new Pair(c, 1));
            }

            if (stack.peek().count == k) {
                stack.pop(); // remove duplicates
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.c);
            }
        }

        return sb.toString();
    }
}
