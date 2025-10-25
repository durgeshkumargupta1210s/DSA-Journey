import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/"); // split by "/"
        Stack<String> stack = new Stack<>();
        
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // ignore empty parts and "."
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // move up one directory
                }
            } else {
                // valid directory name
                stack.push(part);
            }
        }
        
        // Build the simplified path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        // if stack is empty, return root "/"
        return result.length() == 0 ? "/" : result.toString();
    }
}
