class Solution {
    public int minimumChairs(String s) {
        int count=0;
        int ans=0;

        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='E'){
                count++;
            }
            else{
                ans=Math.max(ans,count);
                count--;
            }
        }
        ans=Math.max(ans,count);

        return ans;

        
    }
}