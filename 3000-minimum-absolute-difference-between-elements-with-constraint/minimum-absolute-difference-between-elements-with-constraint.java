import java.util.*;

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {

        int n = nums.size();
        int ans = Integer.MAX_VALUE;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = x; i < n; i++) {

            set.add(nums.get(i - x));

            int curr = nums.get(i);

            Integer floor = set.floor(curr);
            if (floor != null) {
                ans = Math.min(ans, Math.abs(curr - floor));
            }

            Integer ceil = set.ceiling(curr);
            if (ceil != null) {
                ans = Math.min(ans, Math.abs(curr - ceil));
            }

            if (ans == 0) {
                return 0;
            }
        }

        return ans;
    }
}
