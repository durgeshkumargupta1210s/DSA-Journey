class Solution {
    public int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int i=nums.length-1; i>=0; i--){
            int dist=Math.abs(nums[i]-0);
            if(dist<min){
                min=dist;
                ans=nums[i];
            }
            
        }
        return ans;
        
    }
}