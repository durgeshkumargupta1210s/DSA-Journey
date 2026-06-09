class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            maxi=Math.max(maxi,nums[i]);
            mini=Math.min(mini,nums[i]);
        }

        long diff=maxi-mini;

        return diff*k;
        
    }
}