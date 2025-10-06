class Solution {
    public boolean predictTheWinner(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int total=0;
        int [][] dp=new int [nums.length+1][nums.length+1];
        for(int i=0; i<nums.length; i++){
            total+=nums[i];
        }

        int p1=OptimalGameStrategy(nums,left,right,dp);
        int p2=total-p1;

        return p1>=p2;
        
    }
    public int OptimalGameStrategy(int [] nums, int left, int right, int [][] dp){
        if(left>right){
            return 0;
        }
        if(dp[left][right]!=0){
            return dp[left][right];
        }

        int choose_left=nums[left]+Math.min(OptimalGameStrategy(nums,left+2,right, dp), OptimalGameStrategy(nums,left+1, right-1, dp));

        int choose_right=nums[right]+Math.min(OptimalGameStrategy(nums,left+1,right-1, dp), OptimalGameStrategy(nums,left, right-2, dp));

        return dp[left][right]= Math.max(choose_left, choose_right);


    }
}