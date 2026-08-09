class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,0,0,target);
        
    }
    public static int solve(int [] nums, int idx, int sum, int target){
        if(idx==nums.length){
            if(sum==target){
                return 1;
            }
            return 0;
        }

        int add=solve(nums,idx+1,sum+nums[idx], target);
        int subtract=solve(nums,idx+1,sum-nums[idx], target);

        return add+subtract;
    }
}