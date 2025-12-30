class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows=image.length;
        int cols=image[0].length;

        if(image[sr][sc]==color){
            return image;
        }

        int originalcolor=image[sr][sc];
        int [] []directions={{1,0},{-1,0}, {0,1}, {0,-1}};
        image[sr][sc]=color;

        Queue<int[]> q=new LinkedList<>();

        q.add(new int []{sr,sc});

        while(!q.isEmpty()){
            int [] current=q.poll();

            for(int [] dir : directions){
                int newrow=current[0]+dir[0];
                int newcol=current[1]+dir[1];

                if(newrow>=0 &&  newcol>=0 && newrow<rows && newcol<cols && image[newrow][newcol] == originalcolor
 ){
                    image[newrow][newcol] =color;
                    q.offer(new int[]{newrow, newcol});
                }
            }
        }
        return image;
        
    }
}