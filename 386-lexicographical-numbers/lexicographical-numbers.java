import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            print(n, i, result);
        }
        return result;
    }

    private void print(int n, int curr, List<Integer> result) {
        if (curr > n) {
            return;
        }
        result.add(curr);
        for (int i = 0; i <= 9; i++) {
            if (curr * 10 + i > n) {
                break;
            }
            print(n, curr * 10 + i, result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 20;
        List<Integer> result = solution.lexicalOrder(n);
        System.out.println(result);
    }
}