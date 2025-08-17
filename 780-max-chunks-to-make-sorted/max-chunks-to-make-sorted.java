class Solution {
    public int maxChunksToSorted(int[] arr) {
       return chunk_count(arr); 
    }
    private static int chunk_count(int[] arr) {
		// TODO Auto-generated method stub
		int max=0;
		int count=0;
		for(int i=0; i<arr.length; i++) {
			max=Math.max(max, arr[i]);
			if(max==i) {
				count++;
			}
		}
		return count;
	}
}