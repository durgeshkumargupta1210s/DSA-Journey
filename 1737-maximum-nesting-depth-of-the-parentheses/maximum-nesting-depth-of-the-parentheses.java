class Solution {
    public int maxDepth(String s) {
        Stack <Character> st=new Stack<>();
        int result=0;

        for(int i=0; i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch==')'){
                if(ch=='('){
                st.push(ch);
                result=Math.max(result,st.size());
            }
            else{
                st.pop();
            }

            }
        }
        return result;
        
    }
}