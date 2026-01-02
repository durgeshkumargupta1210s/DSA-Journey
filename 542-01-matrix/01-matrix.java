class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int []> q=new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                   q.add(new int[]{i,j});
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
    
 
        int [][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int [] rv=q.poll();

            for(int[] dir:directions){
                int newrow=rv[0]+dir[0];
                int newcol=rv[1]+dir[1];

                if (newrow >= 0 && newcol >= 0 && newrow < m && newcol < n && mat[newrow][newcol] == -1) {

                    // 4. Update distance
                   mat[newrow][newcol]  = mat[rv[0]][rv[1]] + 1;

                    // 5. Add to queue
                    q.offer(new int[]{newrow, newcol});
                }

            }
        }
        return mat;
    }
}