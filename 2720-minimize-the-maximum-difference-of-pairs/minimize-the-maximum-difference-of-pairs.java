import java.util.*;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canFormPairs(nums, p, mid)) {
                high = mid; // try smaller max difference
            } else {
                low = mid + 1; // need bigger difference
            }
        }

        return low;
    }

    // Greedy check: can we form at least p pairs with max difference <= mid?
    private boolean canFormPairs(int[] nums, int p, int mid) {
        int count = 0;
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= mid) {
                count++;
                i += 2; // take this pair, skip both
            } else {
                i++; // try next element
            }

            if (count >= p) return true;
        }

        return false;
    }
}
