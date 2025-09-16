class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return calculate(nums, k) - calculate(nums, k - 1);
    }

    public static int calculate(int[] arr, int target) {
        int sum = 0, si = 0, ans = 0;

        for (int ei = 0; ei < arr.length; ei++) {
            sum += arr[ei] % 2; // count odd numbers

            while (sum > target && si <= ei) {
                sum -= arr[si] % 2;
                si++;
            }

            // all subarrays ending at ei and starting from si..ei are valid
            ans += (ei - si + 1);
        }
        return ans;
    }
}
