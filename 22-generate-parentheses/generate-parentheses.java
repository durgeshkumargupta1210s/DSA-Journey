class Solution {

    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n, "", 0, 0);
        return list;
    }

    public void generate(int n, String ans, int open, int close) {

        if (open == n && close == n) {
            list.add(ans);
            return;
        }

        // Add '(' only if we still have some left
        if (open < n) {
            generate(n, ans + "(", open + 1, close);
        }

        // Add ')' only if it won't make the string invalid
        if (close < open) {
            generate(n, ans + ")", open, close + 1);
        }
    }
}