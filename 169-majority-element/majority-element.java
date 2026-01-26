class Solution {
    public int majorityElement(int[] nums) {

        // Assume the first element is the majority candidate
        int ans = nums[0];

        // Count represents the balance of the current candidate
        int count = 1;

        // Traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {

            // If current element matches the candidate, increase count
            if (nums[i] == ans) {
                count++;
            }

            // Otherwise, decrease count
            else {
                count--;

                /*
                 * If count becomes 0, it means the current candidate
                 * has been canceled out by different elements.
                 * So we choose a new candidate.
                 */
                if (count == 0) {
                    ans = nums[i];   // New candidate
                    count = 1;       // Reset count
                }
            }
        }

        // The final candidate is guaranteed to be the majority element
        return ans;
    }
}
