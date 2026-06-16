class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }

        if(Math.abs(target)>sum){
            return 0;
        }

        if((sum+target)%2!=0){
            return 0;
        }
        
        int req=(target+sum)/2;

        int [] dp=new int[req+1];
        dp[0]=1;

        for(int num : nums){
            for(int s=req ; s>=num; s--){
                dp[s]+=dp[s-num];
            }
        }
        return dp[req];
    }
}