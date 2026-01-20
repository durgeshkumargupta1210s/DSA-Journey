class Solution {

    /*
     This method finds indices of the previous/next greater or smaller elements
     using a monotonic stack.

     Parameters:
     - arr          : input array
     - defaultIndex : -1 for previous element, n for next element
     - isGreater    : true  → find greater elements
                      false → find smaller elements

     Returns:
     - res[i] gives the index of the required element for i
     */
    public int[] getGreaterOrSmallerElementIndices(int[] arr, int defaultIndex, boolean isGreater) {

        int n = arr.length;
        int[] res = new int[n];

        // Stack stores indices and maintains monotonic order
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Direction handling:
            // defaultIndex == -1 → previous element (left to right)
            // defaultIndex != -1 → next element (right to left)
            int ind = (defaultIndex == -1) ? i : (n - 1 - i);

            // Initialize result with default value
            res[ind] = defaultIndex;

            /*
             Pop elements that break monotonic condition:
             - For greater:
               previous → pop while stack top < current
               next     → pop while stack top <= current
             - For smaller:
               previous → pop while stack top > current
               next     → pop while stack top >= current
            */
            while (isGreater && !st.isEmpty() &&
                  ((defaultIndex == -1 && arr[st.peek()] < arr[ind]) ||
                   (defaultIndex != -1 && arr[st.peek()] <= arr[ind]))) {
                st.pop();
            }

            while (!isGreater && !st.isEmpty() &&
                  ((defaultIndex == -1 && arr[st.peek()] > arr[ind]) ||
                   (defaultIndex != -1 && arr[st.peek()] >= arr[ind]))) {
                st.pop();
            }

            // Top of stack is the nearest valid index
            if (!st.isEmpty()) {
                res[ind] = st.peek();
            }

            // Push current index
            st.push(ind);
        }

        return res;
    }

    /*
     This function counts the number of subarrays of size ≤ k
     where the element at index `ind` is the minimum or maximum.

     Parameters:
     - left  : left boundary
     - right : right boundary
     - ind   : fixed index (element acting as min/max)
     - k     : maximum allowed subarray size
     */
    public long getCount(int left, int right, int ind, int k) {

        // Restrict right boundary to satisfy subarray length ≤ k
        right = Math.min(right, ind + k - 1);

        // First valid left index for subarrays of length k
        int first_ind = Math.max(left, ind - k + 1);

        // Second boundary where subarray length starts shrinking
        int second_ind = Math.max(left, right - k + 1);

        /*
         Count subarrays where:
         - left side is fixed at or after second_ind
         */
        long count = (long)(ind - second_ind + 1) * (right - ind + 1);

        /*
         Count subarrays where:
         - left side expands gradually from first_ind to second_ind - 1
         (Arithmetic progression sum)
         */
        if (first_ind < second_ind) {
            int num = second_ind - first_ind;
            count += (long)(num * (2 * (right - ind) - num + 1)) / 2;
        }

        return count;
    }

    /*
     Main function:
     Calculates sum of (minimum + maximum) of all subarrays
     with length ≤ k.
     */
    public long minMaxSubarraySum(int[] nums, int k) {

        // Previous and next greater elements
        int[] prevGreater = getGreaterOrSmallerElementIndices(nums, -1, true);
        int[] nextGreater = getGreaterOrSmallerElementIndices(nums, nums.length, true);

        // Previous and next smaller elements
        int[] prevSmaller = getGreaterOrSmallerElementIndices(nums, -1, false);
        int[] nextSmaller = getGreaterOrSmallerElementIndices(nums, nums.length, false);

        long count = 0;

        // Iterate over each element as min/max contributor
        for (int ind = 0; ind < nums.length; ind++) {

            // Boundaries where nums[ind] is maximum
            int left_max = prevGreater[ind] + 1;
            int right_max = nextGreater[ind] - 1;

            // Boundaries where nums[ind] is minimum
            int left_min = prevSmaller[ind] + 1;
            int right_min = nextSmaller[ind] - 1;

            // Restrict subarrays to length ≤ k
            right_max = Math.min(right_max, ind + k - 1);
            right_min = Math.min(right_min, ind + k - 1);

            // Count contributions
            long count_max = getCount(left_max, right_max, ind, k);
            long count_min = getCount(left_min, right_min, ind, k);

            // Add weighted contribution
            count += (count_max + count_min) * nums[ind];
        }

        return count;
    }
}
