import java.util.Arrays;

class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        boolean[] ans = new boolean[n];

        Arrays.sort(nums);

        boolean[] dp = new boolean[k + 1];
        dp[0] = true;

        int i=0;

        for (int x = 1; x <= n; x++) {

            while (i < n && nums[i] < x) {
                int val = nums[i];
                for (int s = k; s >= val; s--) {
                    dp[s] |= dp[s - val];
                }
                i++;
            }

            int ncapped = n - i;
            int maxUse = Math.min(ncapped, k / x);

            for (int j = 0; j <= maxUse; j++) {
                if (dp[k - j * x]) {
                    ans[x - 1] = true;
                    break;
                }
            }
        }
        return ans;
    }
}