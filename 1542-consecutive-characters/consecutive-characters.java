class Solution {
    public int maxPower(String s) {
        int len=1;
        int max=Integer.MIN_VALUE;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                len++;
            }
            else{
                max=Math.max(max,len);
                len=1;
            }
        }
        max=Math.max(max,len);

        return max;
        
    }
}