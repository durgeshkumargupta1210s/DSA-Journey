class Solution {
    public int thirdMax(int[] nums) {
        return maximum(nums);
    }
    public static int maximum(int[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int count=1;
		for(int i=arr.length-1; i>0; i--) {
			if(arr[i]!=arr[i-1]) {
				count++;
			}
			if(count==3) {
				return arr[i-1];
			}
		}
		
		return arr[arr.length-1];
	}
}