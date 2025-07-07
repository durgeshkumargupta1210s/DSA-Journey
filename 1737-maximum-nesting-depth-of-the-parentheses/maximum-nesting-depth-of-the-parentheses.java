class Solution {
    public int maxDepth(String s) {
        // Stack <Character> st=new Stack<>();
        int result=0;
        int openBracket=0;

        for(int i=0; i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch==')'){
                if(ch=='('){
                openBracket+=1;
                result=Math.max(result,openBracket);
            }
            else{
               openBracket+=-1;
            }

            }
        }
        return result;
        
    }
}