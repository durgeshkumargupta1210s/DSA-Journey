class Solution {
    public int strStr(String haystack, String needle) {
        int n=needle.length();
        if(haystack.equals(needle)){
            return 0;
        }
        for(int i=0; i<=haystack.length()-n; i++){
            String str=haystack.substring(i,i+n);
            if(str.equals(needle)){
                return i;
            }
        }
        return -1;
        
    }
}