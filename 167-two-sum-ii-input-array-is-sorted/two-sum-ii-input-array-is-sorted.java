class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return indexfound(numbers,target);
    }
    public static int[] indexfound(int[] arr, int target) {
		// TODO Auto-generated method stub
		int i=0;
		int j=arr.length-1;
		int sum=0;
		while(i<j) {
			 sum=arr[i]+arr[j];
			if(sum==target) {
				break;
			}
			else if(sum>target) {
				j--;
			}
			else {
				i++;
			}
		}
		return new int[] {i+1,j+1} ;
	}
}