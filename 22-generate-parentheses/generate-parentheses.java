class Solution {
    static List<String> list;
    public List<String> generateParenthesis(int n) {
        list=new ArrayList<>();
        solve(n,0,0,"");
        return list;
        
    }
    public static void solve(int n, int open , int closed, String ans){
        if(open==n && closed==n){
            list.add(ans);
            return;
        }

        if(open<n){
            solve(n,open+1,closed,ans+"(");
        }

        if(closed<open){
            solve(n,open,closed+1,ans+")");
        }


    }
}