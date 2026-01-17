class Solution {
    public int[] resultsArray(int[] nums, int k) {

        // Total number of elements in the input array
        int n = nums.length;

        // Result array will store answer for each window of size k
        int[] result = new int[n - k + 1];

        // 'breaks' counts how many times the consecutive sequence breaks in a window
        int breaks = 0;

        // Sliding window pointers
        int start = 0;        // start index of window
        int end = k - 1;      // end index of window

        // Index to fill result array
        int idx = 0;

        /* ---------------------------------------------------------
           Step 1: Process the first window
           Count how many adjacent elements are NOT consecutive
           --------------------------------------------------------- */
        for (int i = start; i < end; i++) {
            // If next element is not current + 1, sequence is broken
            if (nums[i + 1] != nums[i] + 1) {
                breaks++;
            }
        }

        // If there are no breaks, last element of window is valid
        result[idx++] = (breaks == 0) ? nums[end] : -1;

        /* ---------------------------------------------------------
           Step 2: Slide the window across the array
           --------------------------------------------------------- */
        while (end + 1 < n) {

            // Remove the effect of the element leaving the window
            if (nums[start + 1] != nums[start] + 1) {
                breaks--;
            }

            // Move window forward
            start++;
            end++;

            // Add the effect of the new element entering the window
            if (nums[end] != nums[end - 1] + 1) {
                breaks++;
            }

            // Store result for current window
            result[idx++] = (breaks == 0) ? nums[end] : -1;
        }

        // Return the final result array
        return result;
    }
}
