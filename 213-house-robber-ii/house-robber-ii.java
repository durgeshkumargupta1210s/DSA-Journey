class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Edge case: only one house
        if (n == 1) return nums[0];

        int[] temp1 = new int[n - 1]; // Exclude last house
        int[] temp2 = new int[n - 1]; // Exclude first house

        // Fill temp1 with [0 .. n-2]
        for (int i = 0; i < n - 1; i++) {
            temp1[i] = nums[i];
        }

        // Fill temp2 with [1 .. n-1]
        for (int i = 1; i < n; i++) {
            temp2[i - 1] = nums[i];
        }

        return Math.max(RobberSO(temp1), RobberSO(temp2));
    }

    public int RobberSO(int[] arr) {
        if (arr.length == 1) return arr[0];

        int prev2 = arr[0];
        int prev = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int rob = arr[i] + prev2;
            int dontRob = prev;
            int curr = Math.max(rob, dontRob);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
