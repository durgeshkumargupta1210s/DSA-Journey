class Solution {

    static Set<List<Integer>> set;

    public List<List<Integer>> findSubsequences(int[] nums) {

        set = new HashSet<>();

        solve(nums, 0, -1, new ArrayList<>());

        return new ArrayList<>(set);
    }

    public static void solve(int[] nums, int idx, int prev, List<Integer> curr) {

        if (curr.size() >= 2) {
            set.add(new ArrayList<>(curr));
        }

        if (idx == nums.length) {
            return;
        }

        solve(nums, idx + 1, prev, curr);

        if (prev == -1 || nums[idx] >= nums[prev]) {

            curr.add(nums[idx]);

            solve(nums, idx + 1, idx, curr);

            curr.remove(curr.size() - 1);
        }
    }
}