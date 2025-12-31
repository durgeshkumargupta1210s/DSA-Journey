class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length; 
        int n=grid[0].length;
        int freshcount=0;

        Queue<int[]> q=new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.offer(new int[] {i,j});
                }
                else if(grid[i][j]==1){
                    freshcount++;
                }
            }
        }
        if(freshcount==0){
            return 0;
        }

        int [][] directions={{1,0}, {-1,0}, {0,1},{0,-1}};
        int min=0;

        while(!q.isEmpty()){
           int size=q.size();
           boolean rotten=false;
           for(int i=0; i<size; i++){
            int [] current=q.poll();


            for(int [] dir : directions){
               int r=current[0]+dir[0];
               int c=current[1]+dir[1];


               if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1){
                grid[r][c]=2;
                q.offer(new int []{r,c});
                rotten =true;
                freshcount--;

               }
            }


           }
           if(rotten){
            min++;
           }
        }

        return freshcount==0 ? min :-1;
        
    }
}