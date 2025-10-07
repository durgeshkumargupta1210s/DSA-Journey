class Solution {
    public String answerString(String word, int numFriends) {

       int  maxLength=word.length()-(numFriends-1);
        String str="";
        if (numFriends == 1) return word;


        for(int i=0; i<word.length(); i++){
            int end=Math.min(word.length(),i+maxLength);
            String newStr=word.substring(i, end);

            if(newStr.compareTo(str)>0){
                str=newStr;
            }
        }
        return str;
        
    }
}