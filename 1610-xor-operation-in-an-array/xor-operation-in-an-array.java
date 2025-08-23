class Solution {
    public int xorOperation(int n, int start) {
      return   xorOperations(n,start);
    }
    private static int  xorOperations(int n, int start) {
		// TODO Auto-generated method stub
		int [] arr=new int[n];
		for(int i=0; i<n;i++) {
			arr[i] = start + 2 * i;
		}
		int xor=0;
		for(int i=0; i<arr.length; i++) {
			xor=xor^arr[i];
		}
		return xor;
	}
}