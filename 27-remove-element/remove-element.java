class Solution {
    public int removeElement(int[] nums, int val) {

        // 'c' is the index where we will place the next valid element
        // It also represents the count of elements not equal to 'val'
        int c = 0;

        // Traverse through the entire array
        for (int i = 0; i < nums.length; i++) {

            // If current element is NOT equal to the value to be removed
            if (nums[i] != val) {

                // Copy this element to the position 'c'
                nums[c] = nums[i];

                // Move to the next position for valid elements
                c++;
            }
        }

        // Return the number of elements remaining after removal
        return c;
    }
}
