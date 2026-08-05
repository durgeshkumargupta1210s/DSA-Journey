class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len=1;
        int max=Integer.MIN_VALUE;
        for(int i=1; i<nums.length; i++){
            if(nums[i]>nums[i-1]){
                len++;
            }
            else{
                max=Math.max(max,len);
                len=1;
            }
        }
        max=Math.max(max,len);

        return max;
        
    }
}