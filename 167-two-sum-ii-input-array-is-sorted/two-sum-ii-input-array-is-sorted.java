class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // Variable to store the sum of two numbers
        int sum = 0;

        // Left pointer starts from the beginning of the array
        int left = 0;

        // Right pointer starts from the end of the array
        int right = numbers.length - 1;

        // Continue searching until the two pointers meet
        while (left < right) {

            // Calculate the current sum of elements at left and right pointers
            sum = numbers[left] + numbers[right];

            // If the sum equals the target, we found the required pair
            if (sum == target) {
                break;
            }

            // If the sum is smaller than the target,
            // move the left pointer to increase the sum
            else if (sum < target) {
                left++;
            }

            // If the sum is greater than the target,
            // move the right pointer to decrease the sum
            else {
                right--;
            }
        }

        // Return indices in 1-based indexing as required by the problem
        return new int[]{left + 1, right + 1};
    }
}