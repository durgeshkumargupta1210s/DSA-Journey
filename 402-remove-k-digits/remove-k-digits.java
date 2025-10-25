import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();

        for (char digit : num.toCharArray()) {
            // Remove digits from stack if they are greater than current digit
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }

        // Remove remaining digits from the end if k > 0
        while (k > 0 && !stack.isEmpty()) {
            stack.removeLast();
            k--;
        }

        // Build the final number
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
