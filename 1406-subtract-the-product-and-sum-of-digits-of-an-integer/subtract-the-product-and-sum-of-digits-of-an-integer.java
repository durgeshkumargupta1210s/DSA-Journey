class Solution {
    public int subtractProductAndSum(int n) {
       return  subtractProductSum(n);
    }
    private static int  subtractProductSum(int n) {
		// TODO Auto-generated method stub
		int sum=0;
		int pro=1;
		while(n>0) {
			int rem=n%10;
			sum+=rem;
			pro*=rem;
			n=n/10;
			
		}
		return pro -sum;
	}
}