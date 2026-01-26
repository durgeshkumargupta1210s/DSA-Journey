class Solution {
    public int removeDuplicates(int[] nums) {

        // 'idx' is the position where the next valid element will be placed
        // It also represents the length of the updated array
        int idx = 0;

        // Traverse through the entire array
        for (int i = 0; i < nums.length; i++) {

            /*
             * Condition to keep an element:
             *
             * 1. If idx < 2:
             *    - Always allow the first two elements (no restriction yet)
             *
             * 2. If nums[i] != nums[idx - 2]:
             *    - This ensures that the current element is not appearing
             *      more than twice.
             *    - Because if nums[i] equals nums[idx-2],
             *      it means it has already occurred twice.
             */
            if (idx < 2 || nums[i] != nums[idx - 2]) {

                // Place the valid element at index 'idx'
                nums[idx] = nums[i];

                // Move idx forward for the next valid position
                idx++;
            }
        }

        // Return the number of valid elements after removing extra duplicates
        return idx;
    }
}
