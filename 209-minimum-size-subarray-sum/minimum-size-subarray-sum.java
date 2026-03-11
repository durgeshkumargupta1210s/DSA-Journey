class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int si=0;
        int ans=Integer.MAX_VALUE;
        int sum=0;

        for(int ei=0; ei<nums.length; ei++){
            sum+=nums[ei];

            while(sum>=target){
                ans=Math.min(ans,ei-si+1);
                sum-=nums[si];
                si++;
            }
        }
        return ans==Integer.MAX_VALUE ? 0 : ans;
        
    }
}