class Solution {
    public int minOperations(int[] nums) {

        // Stores the number of flip operations performed
        int count = 0;

        // Length of the binary array
        int n = nums.length;

        /*
         * Traverse the array from left to right till index (n - 3)
         * because each operation requires exactly 3 consecutive elements.
         */
        for (int i = 0; i <= n - 3; i++) {

            /*
             * If the current element is 0, it must be flipped.
             * The only way to change nums[i] is to perform an operation
             * starting at index i.
             */
            if (nums[i] == 0) {

                // Flip nums[i] from 0 → 1
                nums[i] = 1;

                // Flip nums[i+1]: 0 → 1 or 1 → 0
                nums[i + 1] = (nums[i + 1] == 0) ? 1 : 0;

                // Flip nums[i+2]: 0 → 1 or 1 → 0
                nums[i + 2] = (nums[i + 2] == 0) ? 1 : 0;

                // Increment operation count
                count++;
            }
        }

        /*
         * After processing till n - 3, we can no longer apply any operation.
         * If the last two elements are both 1, the transformation is successful.
         * Otherwise, it is impossible to convert the array fully to 1s.
         */
        if (nums[n - 1] == 1 && nums[n - 2] == 1) {
            return count;
        }

        // If any of the last two elements is 0, return -1
        return -1;
    }
}
