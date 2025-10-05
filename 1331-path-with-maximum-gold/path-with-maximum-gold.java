class Solution {
    public int getMaximumGold(int[][] grid) {
        int total=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    int gold=CalculateMaximumGold(grid,i,j);
                    total=Math.max(total,gold);
                }
            }
        }
        return total;
        
    }

    public int CalculateMaximumGold(int [][]grid, int cr, int cc){
        if(cr<0 || cc <0 || cr>=grid.length|| cc>=grid[0].length || grid[cr][cc]==0){
            return 0;
        }

        int temp=grid[cr][cc];
        grid[cr][cc]=0;

        int left=CalculateMaximumGold(grid,cr, cc-1);
        int right=CalculateMaximumGold(grid,cr, cc+1);
        int up=CalculateMaximumGold(grid, cr-1, cc);
        int down =CalculateMaximumGold(grid,cr+1,cc );

        grid[cr][cc]=temp;

        return temp+Math.max(Math.max(left,right),Math.max(up, down));


    } 
}