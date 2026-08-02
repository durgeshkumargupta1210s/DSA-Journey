class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(0)){
                    if(isWordExist(i,j,board,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    public static boolean isWordExist(int cr, int cc, char[][] board, String word, int idx){
        if(idx==word.length()){
            return true;
        }

        if(cr<0 || cc<0 || cr>=board.length || cc >=board[0].length || board[cr][cc]!=word.charAt(idx) ){
            return false;
        }

        char temp=board[cr][cc];
        board[cr][cc]='#';

        boolean found=isWordExist(cr+1,cc,board,word,idx+1)||
                    isWordExist(cr-1,cc,board,word,idx+1)||
                    isWordExist(cr,cc+1,board,word,idx+1)||
                    isWordExist(cr,cc-1,board,word,idx+1);

        board[cr][cc]=temp;

        return found;
    }
}