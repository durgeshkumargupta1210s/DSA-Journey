class Solution {
    public int rob(int[] nums) {
        int [] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,0, dp);
        
    }
    public static int solve(int [] nums,int idx, int [] dp){
        if(idx>=nums.length){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int skip=solve(nums,idx+1, dp);
        int take=nums[idx]+solve(nums,idx+2, dp);

        return dp[idx]= Math.max(skip,take);

    }
}