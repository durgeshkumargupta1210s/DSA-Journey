class Solution {

    // Function to rotate the array to the right by k steps
    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // If k is greater than array size, take modulo
        // Example: n=7, k=10 → k becomes 3
        k = k % n;

        // Step 1: Reverse the entire array
        // Example: [1,2,3,4,5,6,7] → [7,6,5,4,3,2,1]
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        // Example (k=3): [7,6,5,4,3,2,1] → [5,6,7,4,3,2,1]
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining n-k elements
        // Example: [5,6,7,4,3,2,1] → [5,6,7,1,2,3,4]
        reverse(nums, k, n - 1);
    }

    // Helper function to reverse elements between left and right index
    public void reverse(int[] nums, int left, int right) {

        // Swap elements until left crosses right
        while (left < right) {

            // Store left element temporarily
            int temp = nums[left];

            // Swap left and right elements
            nums[left] = nums[right];
            nums[right] = temp;

            // Move pointers inward
            left++;
            right--;
        }
    }
}
