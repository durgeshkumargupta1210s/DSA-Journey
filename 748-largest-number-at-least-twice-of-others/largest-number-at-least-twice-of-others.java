class Solution {
    public int dominantIndex(int[] nums) {
        return indexfound(nums);
    }

    public static int indexfound(int[] arr) {
		// TODO Auto-generated method stub
		int maxindex=maxelement(arr);
		for(int i=0; i<arr.length; i++) {
			if(i!=maxindex && arr[maxindex]<2*arr[i]) {
				return -1;
			}
		}
		return maxindex;
	}

	public static int maxelement(int[] arr) {
		// TODO Auto-generated method stub
		int j=arr[0];
		int index=0;
		for(int i=0; i<arr.length; i++) {
			if(j<arr[i]) {
				j=arr[i];
				index=i;
			}
		}
		return index;
	}

}