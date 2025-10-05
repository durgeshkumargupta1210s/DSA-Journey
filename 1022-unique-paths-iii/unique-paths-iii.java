class Solution {
    public int uniquePathsIII(int[][] grid) {
        int cr=0, cc=0, empty=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0){
                   empty++;
                }
                else if(grid[i][j]==1){
                    cr=i;
                    cc=j;
                }
            }
        }
        return totalPath(grid,cr,cc,empty+1);
        
    }
    public int totalPath(int [][] grid, int cr, int cc, int remain){
        
        if(cr<0 || cc<0 || cc>=grid[0].length || cr>=grid.length || grid[cr][cc]==-1){
            return 0;
        }
        if(grid[cr][cc]==2){
            return remain==0 ? 1 :0;
        }

        int temp=grid[cr][cc];
        grid[cr][cc]=-1;
        int left=totalPath(grid,cr,cc-1,remain-1);
        int right=totalPath(grid,cr,cc+1, remain-1);
        int up=totalPath(grid,cr-1,cc, remain-1);
        int down=totalPath(grid,cr+1,cc, remain-1);

        grid[cr][cc]=temp;

        return left+right+up+down;
    }
}