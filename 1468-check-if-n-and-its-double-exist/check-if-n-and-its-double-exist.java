class Solution {
    public boolean checkIfExist(int[] arr) {
        return isexist(arr);
    }
    public static boolean isexist(int[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
	for(int i=0; i<arr.length; i++) {
		for(int j=i; j<arr.length; j++) {
			if(i != j && (arr[i] == 2 * arr[j] || arr[j] == 2 * arr[i])) {
				return true;
			}
		}
	}
		return false;
	}
}