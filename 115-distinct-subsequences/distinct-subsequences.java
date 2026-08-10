class Solution {
    static int [][] dp;
    public int numDistinct(String s, String t) {
        dp=new int[s.length()+1][t.length()+1];
        for(int [] a : dp){
            Arrays.fill(a,-1);
        }
        return solve(s,t,0,0);
        
    }
    public static int solve(String s, String t, int i,int j){
        if(j==t.length()){
            return 1;
        }

        if(i==s.length()){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int first=0;
        int second=0;

        if(s.charAt(i)==t.charAt(j)){
            first=solve(s,t,i+1,j+1);
        }
            second=solve(s,t,i+1,j);

        return dp[i][j]= first+second;

    }
}