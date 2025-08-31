class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        return nearest_valid(points,x,y);
    }
    private static int nearest_valid(int[][] points, int x, int y) {
		// TODO Auto-generated method stub
		int ans=Integer.MAX_VALUE;
		int index=-1;
		for(int i=0; i<points.length; i++) {
			int xx=points[i][0];
			int yy=points[i][1];
			if(xx==x || yy==y) {
				int m=Math.abs(x-xx)+Math.abs(y-yy);
				if (m < ans) {
                    ans = m;
                    index = i;
                }
				
			}
		
	}
		
		return index;
}
} 