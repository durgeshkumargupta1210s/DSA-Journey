class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean [][] visited=new boolean[n][m];
        int max=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid[i][j]==1){
                    max=Math.max(max,bfs(i,j,visited, grid));
                }
            }
        }
        return max;
        
    }

    public static int bfs(int sr, int sc, boolean[][] visited, int [][] grid){
        Queue<int []> q=new LinkedList<>();

        q.add(new int []{sr,sc});
        visited[sr][sc]=true;
        int count=1;

        int [][] directions={{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
           int [] current=q.poll();

           for(int [] arr : directions){
             int r=current[0]+arr[0];
             int c=current[1]+arr[1];

             if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && visited[r][c]==false && grid[r][c]==1){
                visited[r][c]=true;

                q.add(new int [] {r,c});

                count++;
             }
           }
        }
        return count;
    }
}