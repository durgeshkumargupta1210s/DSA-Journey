import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sorting helps avoid duplicates in the set
        HashSet<List<Integer>> set = new HashSet<>();
        subset(nums, 0, new ArrayList<>(), set);
        return new ArrayList<>(set); // Convert HashSet to List
    }

    public void subset(int[] nums, int idx, ArrayList<Integer> current, HashSet<List<Integer>> set) {
        if (idx == nums.length) {
            set.add(new ArrayList<>(current)); // Add a copy to set
            return;
        }

        // Include nums[idx]
        current.add(nums[idx]);
        subset(nums, idx + 1, current, set);

        // Exclude nums[idx]
        current.remove(current.size() - 1);
        subset(nums, idx + 1, current, set);
    }
}
