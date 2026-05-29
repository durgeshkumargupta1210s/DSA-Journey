class Solution {
    public int minElement(int[] nums) {
       int ans=Integer.MAX_VALUE;
       for(int i=0; i<nums.length; i++){
        int digit=nums[i];
        int sum=0;
        while(digit>0){
            int rem=digit%10;
            sum+=rem;
            digit=digit/10;
        }
        ans=Math.min(ans,sum);

       } 
       return ans;
    }
}