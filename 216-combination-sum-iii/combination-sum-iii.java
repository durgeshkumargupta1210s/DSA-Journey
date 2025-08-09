import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        HashSet<List<Integer>> set = new HashSet<>();
        combinationSum(nums, new ArrayList<>(), set, k, n, 0);
        return new ArrayList<>(set);
    }

    public static void combinationSum(int[] nums, ArrayList<Integer> current,
                                       HashSet<List<Integer>> set, int k, int n, int idx) {
        if (n == 0) {
            if (current.size() == k) {
                set.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (nums[i] <= n) {
                current.add(nums[i]);
                combinationSum(nums, current, set, k, n - nums[i], i + 1);
                current.remove(current.size() - 1); 
            }
        }
    }
}
