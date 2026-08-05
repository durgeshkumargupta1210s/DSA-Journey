class Solution {
    static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    static List<String> list;
    public List<String> letterCombinations(String digits) {
        list=new ArrayList<>();
        solve(digits,"",0);
        return list;

    }
    public static void solve(String digits, String ans, int idx){
        if(idx==digits.length()){
            list.add(ans);
            return;
        }
        int num=digits.charAt(idx)-'0';

        String word=key[num];

        for(int i=0; i<word.length(); i++){
            solve(digits,ans+word.charAt(i),idx+1);
        }
    }
}