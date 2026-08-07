class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }

        if(sum%2!=0){
            return false;
        }

        int [][]dp=new int[nums.length][(sum/2)+1];
        for(int [] a: dp){
            Arrays.fill(a,-1);
        }

        return solve(nums,0,sum/2, dp);
        
    }
    public static boolean solve(int [] nums, int idx, int target, int[][]dp){
        if(target==0){
            return true;
        }

        
        if(idx==nums.length){
            return false;
        }

        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }

        boolean skip=solve(nums,idx+1,target, dp);
        boolean take=false;

        if(target>=nums[idx]){
            take=solve(nums,idx+1,target-nums[idx], dp);
        }
       boolean ans=take || skip;

        dp[idx][target]=ans?1:0;
        return ans;
    }
}