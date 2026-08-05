class Solution {
    static boolean [][] visited;
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        visited=new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==word.charAt(0)){
                    if(solve(i,j,board,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean solve(int cr, int cc, char[][] board, String word, int idx){
        if(idx==word.length()){
            return true;
        }

        if(cr<0 || cc<0 || cr>=board.length || cc>=board[0].length || board[cr][cc]!=word.charAt(idx) || visited[cr][cc]==true){
            return false;
        }

        visited[cr][cc]=true;
        boolean found=solve(cr+1,cc,board,word,idx+1)||
                      solve(cr-1,cc,board,word,idx+1)||
                      solve(cr,cc+1,board,word,idx+1)||
                      solve(cr,cc-1,board,word,idx+1);
        visited[cr][cc]=false;

        return found;

    }

}