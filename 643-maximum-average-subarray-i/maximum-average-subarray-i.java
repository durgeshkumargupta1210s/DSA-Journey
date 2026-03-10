class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int si=0;
        double avg=0;
        double ans=0;
        double sum=0;
        for(int i=0; i<k; i++){
            sum+=nums[i];
        }

        avg=sum/k;
        ans=sum/k;

        for(int ei=k; ei<nums.length; ei++){
            sum+=nums[ei];
            sum-=nums[si];
            si++;
            avg=sum/k;
            ans=Math.max(ans,avg);
        }
        return ans;

        
    }
}