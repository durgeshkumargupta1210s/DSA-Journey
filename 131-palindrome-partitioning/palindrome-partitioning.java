class Solution {
    static List<List<String>> ans=new ArrayList<>();
    public List<List<String>> partition(String s) {
        ans.clear(); 
        solve(s,new ArrayList<>());
        return ans;
        
    }
    public static void solve(String s , List<String> list){
        if(s.length()==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=1; i<=s.length(); i++){
            String a=s.substring(0,i);
            if(isPalindrome(a)){
                list.add(a);
                solve(s.substring(i),list);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int i=0; 
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}