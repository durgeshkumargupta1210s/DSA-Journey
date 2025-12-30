class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean [][]visited= new boolean[row][col];

        int ans=0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                   ans++;
                   findComponent(grid, visited, i, j);
                }
            }
        }
        return ans;
        
    }

    public void findComponent(char [][] grid, boolean [][] visited, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length|| grid[row][col]=='0' || visited[row][col]){
            return;
        }

        visited[row][col]=true;
        findComponent(grid, visited, row+1, col);
        findComponent(grid, visited, row-1, col);
        findComponent(grid, visited, row, col+1);
        findComponent(grid, visited, row, col-1);
    }
}