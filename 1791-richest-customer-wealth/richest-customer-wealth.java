class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans=0;
        for(int [] arr : accounts){
            int sum=0;
            for(int i=0; i<arr.length; i++){
                sum+=arr[i];
            }
            ans=Math.max(ans,sum);
        }
        return ans;
        
    }
}