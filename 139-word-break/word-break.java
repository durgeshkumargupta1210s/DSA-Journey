class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int [] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return isPossible(s,wordDict,0, dp);
        
    }
    public static boolean isPossible(String s,List<String>dict, int idx, int [] dp ){
        if(idx==s.length()){
            return true;
        }

        if(dp[idx]!=-1){
            return dp[idx]==1;
        }

        for(int end=idx+1; end<=s.length(); end++){
            String word=s.substring(idx,end);

            if(dict.contains(word) && isPossible(s,dict,end,dp)){
                dp[idx]=1;
                return true;
            }
        }
        dp[idx]=0;
        return false;
    }
}