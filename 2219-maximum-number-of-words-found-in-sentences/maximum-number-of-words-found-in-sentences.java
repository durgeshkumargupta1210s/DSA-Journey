class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<sentences.length; i++){
            String s=sentences[i];
            String [] arr=s.split(" ");
            ans=Math.max(ans,arr.length);  
        }
        return ans;
        
    }
}