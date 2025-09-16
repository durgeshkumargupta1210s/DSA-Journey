class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum1=calculate(nums,goal);
        int sum2=calculate(nums,goal-1);

        return Math.abs(sum2-sum1);
    }

    public static int calculate(int [] nums, int target){
        if(target<0) return 0;
        int sum=0, si=0, count=0;
        for(int ei=0; ei<nums.length; ei++){
            sum+=nums[ei];

            while(sum>target){
                sum-=nums[si];
                si++;
            }

            count+=(ei-si+1);

        }
        return count;
    }
}