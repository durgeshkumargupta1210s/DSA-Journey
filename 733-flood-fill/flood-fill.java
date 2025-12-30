class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        newfloodFill(image,sr,sc,color,image[sr][sc]);
        return image;
        
    }
    public void newfloodFill(int[][] image, int sr, int sc, int color,int original){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length ){
            return;
        }
        if(image[sr][sc]!=original || image[sr][sc]==color){
            return;
        }
        image[sr][sc]=color;
        newfloodFill(image, sr+1,sc,color, original);
        newfloodFill(image, sr-1,sc,color, original);
        newfloodFill(image, sr,sc+1,color, original);
        newfloodFill(image, sr,sc-1,color, original);

    }
}