class Solution {
    public boolean rotateString(String s, String goal) {
        for(int i=0; i<s.length();i++){
            String str1=s.substring(0,i);
            String str2=s.substring(i);
            String res=str2+str1;
            if(res.equals(goal)){
                return true;
            }
        }
        return false;
        
    }
}