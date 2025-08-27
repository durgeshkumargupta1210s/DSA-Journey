class Solution {
    public int findKthPositive(int[] arr, int k) {
        return missyou(arr,k) ;
    }
    public static int missyou(int[] arr, int k) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		int count=0;
		int ans=0;
		for(int i=1; i<=arr.length+k; i++) {
			if(!set.contains(i)) {
				count++;
			}
			if(count==k) {
				ans=i;
				break;
			}
		}
		return ans;
	}

}