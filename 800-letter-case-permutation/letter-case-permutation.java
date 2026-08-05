class Solution {
    static List<String> list=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        list.clear();
        solve(s,0,"");
        return list;

        
    }
    public static void solve(String s, int idx, String ans){
        if(idx==s.length()){
          list.add(ans);
          return;
        }
        solve(s,idx+1,ans+s.charAt(idx));

        if(Character.isUpperCase(s.charAt(idx))){
            char ch=Character.toLowerCase(s.charAt(idx));
            solve(s,idx+1,ans+ch);
        }
        else if(Character.isLowerCase(s.charAt(idx))){
            char ch=Character.toUpperCase(s.charAt(idx));
            solve(s,idx+1,ans+ch);
        }
        
    }
}