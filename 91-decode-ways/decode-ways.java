class Solution {
    public int numDecodings(String s) {
        int [] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0, dp);
        
    }
    public static int solve(String s, int idx, int [] dp){
        if(idx==s.length()){
            return 1;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        if(s.charAt(idx)=='0'){
            return 0;
        }

        
        int one=solve(s,idx+1, dp);
        int two=0;

        if(idx+1<s.length()){
            int num=(s.charAt(idx)-'0')*10+s.charAt(idx+1)-'0';

            if(num>=10 && num<=26){
                 two=solve(s,idx+2, dp);
            }
        }

        return dp[idx]= one + two;

    }
}