class Solution {
    public String longestNiceSubstring(String s) {

        return niceSubstring(s);
        
    }

    public static String niceSubstring(String s){
        if(s.length()<2){
            return "";
        }

        Set<Character> set=new HashSet<>();
        for(char ch : s.toCharArray()){
            set.add(ch);
        }

        for(int i=0; i<s.length(); i++){
            char curr=s.charAt(i);
            char oppo;
            if (Character.isLowerCase(curr)) {
                oppo = Character.toUpperCase(curr);
            } else {
                oppo = Character.toLowerCase(curr);
            }

            if(!set.contains(oppo)){
                String left=niceSubstring(s.substring(0,i));
                String right=niceSubstring(s.substring(i+1));


                if(left.length()>=right.length()){
                    return left;
                }
                else{
                    return right;
                }
            }
        }
        return s;
    }
}