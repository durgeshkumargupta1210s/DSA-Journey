class Solution {
    static int [][] dp;
    public int maximalSquare(char[][] matrix) {
        dp=new int[matrix.length][matrix[0].length];
        for(int [] a : dp){
            Arrays.fill(a,-1);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                int current=solve(matrix,i,j);
                max=Math.max(max,current);
            }
        }
        return max*max;
        
    }
    public static int solve(char [][] ch , int i, int j){
        if(i<0 || j<0 || ch[i][j]=='0'){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int top=solve(ch,i-1,j);
        int left=solve(ch,i,j-1);
        int diagonal=solve(ch,i-1,j-1);

        return dp[i][j]= 1+Math.min(top,Math.min(left,diagonal));
    }
}