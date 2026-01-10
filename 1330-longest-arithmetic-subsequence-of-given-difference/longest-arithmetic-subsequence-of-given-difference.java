class Solution {
    public int longestSubsequence(int[] arr, int difference) {

        // Map to store longest subsequence ending at a value
        Map<Integer, Integer> dp = new HashMap<>();

        int ans = 1;

        for (int num : arr) {

            // Length of subsequence ending at (num - difference)
            int prevLen = dp.getOrDefault(num - difference, 0);

            // Current length ending at num
            int currLen = prevLen + 1;

            dp.put(num, currLen);

            // Update global maximum
            ans = Math.max(ans, currLen);
        }

        return ans;
    }
}
