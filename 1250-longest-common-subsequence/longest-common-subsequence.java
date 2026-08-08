class Solution {
    static int [][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp=new int[text1.length()][text2.length()];
        for(int [] a: dp){
            Arrays.fill(a,-1);
        }

        return solve(text1,text2,0,0);
        
    }
    static int ans=0;
    public static int solve(String t1, String t2, int i, int j){
        if(i==t1.length() || j==t2.length()){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(t1.charAt(i)==t2.charAt(j)){
            ans=1+solve(t1,t2,i+1,j+1);
        }
        else{
            int f=solve(t1,t2,i+1,j);
            int s=solve(t1,t2,i,j+1);

            ans=Math.max(f,s);
        }

        return dp[i][j]= ans;
    }
}