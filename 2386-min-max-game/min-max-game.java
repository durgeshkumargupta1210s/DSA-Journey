class Solution {

    public int minMaxGame(int[] nums) {

        // Size of current array
        int n = nums.length;

        // Base case:
        // If only one element remains, return it
        if (n == 1) {
            return nums[0];
        }

        // Create a new array of size n/2
        int[] newNums = new int[n / 2];

        // Fill the new array according to game rules
        for (int i = 0; i < n / 2; i++) {

            /*
                For even index:
                newNums[i] = min(nums[2*i], nums[2*i + 1])
            */
            if (i % 2 == 0) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            }

            /*
                For odd index:
                newNums[i] = max(nums[2*i], nums[2*i + 1])
            */
            else {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }
        }

        // Recursively continue the game
        // until only one element remains
        return minMaxGame(newNums);
    }
}