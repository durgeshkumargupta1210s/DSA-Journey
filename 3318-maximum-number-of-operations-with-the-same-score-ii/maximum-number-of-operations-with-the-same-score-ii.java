class Solution {
    public int maxOperations(int[] nums) {
        int n=nums.length;
        int ans=0;

        int[] target={
            nums[0]+nums[1],
            nums[0]+nums[n-1],
            nums[n-1]+nums[n-2]
        };

        for(int t:target){
            int[][] dp=new int[n][n];
            for(int i=0; i<n; i++){
                Arrays.fill(dp[i],-1);
            }
            ans=Math.max(ans, fun(nums,0,n-1,t,dp));
        }

        return ans;
    }

    private int fun(int[] arr, int l, int r, int target, int[][] dp){
        if(r-l+1<2){
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }

        int c=0;

        if(l+1<=r && arr[l]+arr[l+1]==target){
            c=Math.max(c, 1 + fun(arr,l+2,r,target,dp));
        }
        if(l<=r-1 && arr[r-1]+arr[r]==target){
            c=Math.max(c, 1 + fun(arr,l,r-2,target,dp));
        }
        if(arr[l]+arr[r]==target){
            c=Math.max(c, 1 + fun(arr,l+1,r-1,target,dp));
        }

        return dp[l][r]=c;
    }
}