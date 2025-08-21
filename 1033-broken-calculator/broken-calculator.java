class Solution {
    public int brokenCalc(int startValue, int target) {
        return operation(startValue, target);
    }
    private static int  operation(int startvalue, int target) {
		// TODO Auto-generated method stub
       //		applying reverse approach
		
		int count=0;
		while(target>startvalue) {
			if(target%2==0) {
				target/=2; // reverse of multiply
			}
			else {
				target+=1; // reverse of sub
			}
			count++;
		}
		
		return count+(startvalue - target);
	}
}