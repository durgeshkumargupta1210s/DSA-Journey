class Solution {
    public int longestOnes(int[] nums, int k) {

        int count=0;
        int si=0;
        int ans=0;

        for(int ei=0; ei<nums.length; ei++){
            if(nums[ei]==0){
                count++;
            }

            if(count>k){
                if(nums[si]==0){
                    count--;
                }
                si++;
            }
            ans=Math.max(ans,ei-si+1);
        }
        return ans;
        
    }
}