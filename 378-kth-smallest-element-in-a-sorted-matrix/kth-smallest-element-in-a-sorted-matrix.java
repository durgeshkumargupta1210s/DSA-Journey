class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        return elementFound(matrix,k);
    }
   private static int elementFound(int[][] matrix, int k) {
		// TODO Auto-generated method stub
		int m=matrix.length;
		int n=matrix[0].length;
		int [] arr=new int[m*n];
		int p=0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				arr[p]=matrix[i][j];
				p++;
			}
		}
		Arrays.sort(arr);	
		return arr[k-1];
	}
}