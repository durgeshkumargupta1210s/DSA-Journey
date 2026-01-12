class Solution {
    public int maximumValue(String[] strs) {
        int ans=0;

       for(int i=0; i<strs.length; i++){
            String str=strs[i];

            if(isdigit(str)){
                int in=Integer.parseInt(str);
                ans=Math.max(ans,in);
            }
            else{
                ans=Math.max(ans,str.length());
            }
        }
        return ans; 
    }
    public boolean isdigit(String str){
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);

            if(!Character.isDigit(ch)){
                return false;
            }
        }
        return true;
    }

}