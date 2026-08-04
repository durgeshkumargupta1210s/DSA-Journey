class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int [] dp=new int[stoneValue.length];
        Arrays.fill(dp,-1);
        int diff=solve(stoneValue,0, dp);
        if(diff>0){
            return "Alice";
        }
        else if(diff<0){
            return "Bob";
        }
        else{
            return "Tie";
        }
        
        
    }
    public static int solve(int [] stone, int idx, int [] dp){
        if(idx>=stone.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }

        int result=Integer.MIN_VALUE;

        result=Math.max(result,stone[idx]-solve(stone,idx+1, dp));

        if(idx+1<stone.length){
            result=Math.max(result,stone[idx]+stone[idx+1]-solve(stone,idx+2, dp));
        }

        if(idx+2<stone.length){
            result=Math.max(result,stone[idx]+stone[idx+1]+stone[idx+2]-solve(stone,idx+3, dp));
        }
        return dp[idx]= result;
    }
}