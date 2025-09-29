class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int [] prefixMax=new int[n];
        int [] suffixMax=new int [n];
        int [] ans=new int[n-k+1];

        prefixMax[0]=nums[0];
        for(int i=0; i<n; i++){
            if(i%k==0){
                prefixMax[i]=nums[i];
            }
            else{
                prefixMax[i]=Math.max(prefixMax[i-1],nums[i]);
            }
        }

        suffixMax[n-1]=nums[n-1];

        for(int i=n-2; i>=0; i--){
            if((i+1)%k==0){
                suffixMax[i]=nums[i];
            }
            else{
                suffixMax[i]=Math.max(suffixMax[i+1],nums[i]);
            }
        }

        for(int i=0; i<ans.length; i++){
            ans[i]=Math.max(suffixMax[i],prefixMax[i+k-1]);
        }
        return ans;
        
    }
}