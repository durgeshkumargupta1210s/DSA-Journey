class Solution {
    public int findKthLargest(int[] nums, int k) {
       return maximum(nums,k);
    }
    public static int maximum(int[] arr, int k) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int ans=arr[arr.length-k];
		return ans;
	}
}