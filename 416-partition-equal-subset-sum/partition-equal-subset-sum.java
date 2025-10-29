class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }

        if(sum%2!=0){
            return false;
        }
        int [][] dp=new int[nums.length][(sum/2)+1];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }

        return canPartitionArray(nums,sum/2,0,dp);
        
    }
    public boolean canPartitionArray(int []nums,int target, int idx, int [][] dp){
        if(target==0){
            return true;
        }
        if(idx==nums.length){
            return false;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }

        boolean include=false;

        if(nums[idx]<=target){
            include=canPartitionArray(nums,target-nums[idx], idx+1, dp);
        }

        boolean exclude=canPartitionArray(nums,target, idx+1, dp);

        boolean result= include || exclude;

        dp[idx][target]=result?1:0;
        return result;
    }
}