class Solution {
    public boolean isUgly(int n) {
      return is_ugly(n);  
    }
    private static boolean is_ugly(int n) {
		// TODO Auto-generated method stub
		 if (n <= 0) {
	            return false;
	        }
	        int[] factors = {2, 3, 5};
	        for (int num : factors) {
	            while (n % num == 0) {
	                n /= num;
	            }
	        }
	        return n == 1;
	}

}