class Solution {
    public int removeDuplicates(int[] nums) {

        // 'c' is the slow pointer that tracks the index of the last unique element
        int c = 0;

        // Start loop from index 1 because nums[0] is always unique
        for (int i = 1; i < nums.length; i++) {

            // If current element is different from the last unique element
            if (nums[i] != nums[c]) {

                // Move slow pointer forward
                c++;

                // Place the new unique element at index 'c'
                nums[c] = nums[i];
            }
        }

        // Total number of unique elements = c + 1
        return c + 1;
    }
}
