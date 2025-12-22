class Solution {
    public String longestNiceSubstring(String s) {
        int n=s.length();
        String ans="";
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                String sub=s.substring(i,j+1);
                if(isNice(sub)){
                    if(ans.length()< sub.length()){
                        ans=sub;
                    }
                }
            }
        }
        return ans;
        
    }
    public static boolean isNice(String s){
        Set<Character> set=new HashSet<>();
        for(char ch : s.toCharArray()){
            set.add(ch);
        }

        for(char c : s.toCharArray()){
           if (Character.isLowerCase(c)) {
                if (!set.contains(Character.toUpperCase(c))) {
                    return false;
                }
            } 
            else {
                if (!set.contains(Character.toLowerCase(c))) {
                    return false;
                }
            }
        }
        return true;
    }
}