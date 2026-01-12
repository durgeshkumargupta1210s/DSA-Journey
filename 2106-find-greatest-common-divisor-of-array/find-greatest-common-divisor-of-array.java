class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int s=nums[0];
        int g=nums[nums.length-1];
        int ans=0;
        for(int i=1; i<=g; i++ ){
            if(s%i==0 && g%i==0){
                ans=i;
            }
        }
        return ans;
        
    }
}