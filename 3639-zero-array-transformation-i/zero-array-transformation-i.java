class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

      
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            diff[l]++;
            if (r + 1 < n) {
                diff[r + 1]--;
            }
        }

  
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            if (curr < nums[i]) {
                return false;
            }
        }

        return true;
    }
}
