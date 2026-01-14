import java.util.*;

class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;

        // Convert all values to positive for uniformity
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Math.abs(nums[i]);
        }

        // Sort the absolute values
        Arrays.sort(values);

        long totalPairs = 0;

        // For each element, count how many valid partners exist
        for (int i = 0; i < n; i++) {
            int current = values[i];

            // y must satisfy: current/2 <= y <= 2*current
            int minAllowed = (current + 1) / 2; // ceil(current/2)
            int maxAllowed = current * 2;

            // Find first index where value >= minAllowed
            int leftIndex = findFirstGreaterEqual(values, i + 1, n, minAllowed);

            // Find first index where value > maxAllowed
            int rightIndex = findFirstGreater(values, i + 1, n, maxAllowed);

            totalPairs += (rightIndex - leftIndex);
        }

        return totalPairs;
    }

    // Binary search: first index with value >= target
    private int findFirstGreaterEqual(int[] arr, int from, int to, int target) {
        int low = from, high = to;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Binary search: first index with value > target
    private int findFirstGreater(int[] arr, int from, int to, int target) {
        int low = from, high = to;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
