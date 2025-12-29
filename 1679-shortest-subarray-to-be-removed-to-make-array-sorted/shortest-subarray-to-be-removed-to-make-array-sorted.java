class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        
        // Step 1: longest non-decreasing prefix
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        // If entire array is non-decreasing
        if (left == n - 1) {
            return 0;
        }
        
        // Step 2: longest non-decreasing suffix
        int right = n - 1;
        while (right - 1 >= 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        
        // Option 1: remove everything after prefix
        int ans = Math.min(n - left - 1, right);
        
        // Step 3: try to merge prefix and suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                // Remove between i and j
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        return ans;
    }
}
