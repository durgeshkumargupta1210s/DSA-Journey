class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        boolean[][] visited=new boolean[m][n];
        int count=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(grid,i,j,visited);
                    
                }
            }
        }
        return count;  
    }

    public void dfs(char [][] grid, int sr,int sc,boolean[][] visited){
        if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length || visited[sr][sc] || grid[sr][sc]=='0'){
            return ;
        }

        visited[sr][sc]=true;

        dfs(grid,sr+1,sc,visited);
        dfs(grid,sr-1,sc,visited);
        dfs(grid,sr,sc+1,visited);
        dfs(grid,sr,sc-1,visited);  


    }
}