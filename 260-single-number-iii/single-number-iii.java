class Solution {
    public int[] singleNumber(int[] nums) {
        return Single_Number(nums);
        
    }
    public static int[] Single_Number(int [] arr) {
		int xor=0;
		for(int i=0; i<arr.length; i++) {
			xor=xor^arr[i];
		}
		int mask=(xor & (-1 *xor)); // (xor & (~(xor-1));
		int a=0;
		for(int i=0; i<arr.length; i++) {
			if((mask & arr[i])!=0) {
				a=a^arr[i];
			}
		}
		int b=xor^a;
		return new int[] {a,b};
	}
}