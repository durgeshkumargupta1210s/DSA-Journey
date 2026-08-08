class Solution {
    static int [][] dp;
    public int minDistance(String word1, String word2) {
        dp=new int[word1.length()][word2.length()];
        for(int [] a: dp){
            Arrays.fill(a,-1);
        }

        return solve(word1,word2,0,0);
        
    }
    public static int solve(String word1, String word2, int i, int j){

        if(i==word1.length()){
            return word2.length()-j;
        }

        if(j==word2.length()){
            return word1.length()-i;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans;

        if(word1.charAt(i)==word2.charAt(j)){
            ans=solve(word1,word2,i+1,j+1);
        }
        else{
            int del1=1+solve(word1,word2,i+1,j);
            int del2=1+solve(word1,word2,i,j+1);

            ans=Math.min(del1, del2);
        }

        return dp[i][j]= ans;
    }
}