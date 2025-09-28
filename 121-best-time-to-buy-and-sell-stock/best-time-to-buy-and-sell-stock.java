class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int ans=Integer.MIN_VALUE;
        int min=prices[0];

        for(int i=0; i<n; i++){
            if(min>prices[i]){
                min=prices[i];
            }

            ans=Math.max(ans,prices[i]-min);
        }

        return ans;
        
    }
}