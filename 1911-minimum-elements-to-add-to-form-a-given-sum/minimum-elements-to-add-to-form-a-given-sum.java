class Solution {

    // Time Complexity (TC): O(n)
    // - We iterate through the array once to calculate the sum.
    //
    // Space Complexity (SC): O(1)
    // - Only constant extra space is used.

    // This method calculates the minimum number of elements
    // (each with absolute value ≤ limit) required to be added
    // to the array so that its total sum becomes equal to 'goal'
    public int minElements(int[] nums, int limit, int goal) {

        // Use long to safely store the sum and avoid integer overflow
        long sum = 0;

        // Compute the sum of all elements in the array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // Calculate the absolute difference between the desired goal
        // and the current sum. This is the total value we need to adjust.
        long requiredSum = Math.abs((long) goal - sum);

        // Each added element can contribute at most 'limit' (in absolute value).
        // To minimize the number of elements added, we use ceiling division:
        // ceil(requiredSum / limit)
        return (int) ((requiredSum + limit - 1) / limit);
    }
}
