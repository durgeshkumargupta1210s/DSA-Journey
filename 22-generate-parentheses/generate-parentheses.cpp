class Solution {
public:
    vector<string> v;
    vector<string> generateParenthesis(int n) {
        
        generate(n,"",0,0);
        return v;
        
    }
    void generate(int n, string ans, int open, int close){
        if(open==n && close==n){
            v.push_back(ans);
            return;
        }

        if(open<n){
            generate(n,ans+"(" ,open+1,close);
        }
        if(close<open){
          generate(n,ans+")",open,close+1);
        }
    }
};