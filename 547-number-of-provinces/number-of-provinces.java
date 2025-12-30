class Solution {
    public int findCircleNum(int[][] isConnected) {
        int row=isConnected.length;
        int ans=0;
        boolean[] visited=new boolean[row];

        for(int i=0; i<row; i++){
            if(!visited[i]){
                ans++;
                dfs( isConnected, visited, i);
            }
        }
        return ans;
        
    }

    public void dfs(int [][] grid,boolean[] visited, int node){
        
        visited[node]=true;
        for(int i = 0 ; i < grid.length ; i++){
            if(!visited[i] && grid[node][i] == 1){
                dfs(grid , visited , i);
            }
        }

    }
}