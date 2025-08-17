class Solution {
    public int longestMountain(int[] arr) {
        return longestMountainLength(arr);
    }
    private static int longestMountainLength(int[] arr) {
		// TODO Auto-generated method stub
		int n=arr.length;
		int maxlen=0;
		for(int i=1; i<n-1; i++) {
			if(arr[i]>arr[i-1] && arr[i]>arr[i+1]) {
				int left=i;
				int right=i;
				while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                // Expand right until decreasing sequence breaks
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate mountain length
                int mountainLength = right - left + 1;
                maxlen = Math.max(maxlen, mountainLength);

                // Move `i` to the right end of this mountain to avoid re-checking
                i = right;
			}
		}
		
		return maxlen;
	}
}