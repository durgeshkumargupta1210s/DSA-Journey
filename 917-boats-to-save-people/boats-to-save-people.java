class Solution {
    public int numRescueBoats(int[] people, int limit) {
       return  numberOfRescueBoats(people,limit);
    }
    private static int numberOfRescueBoats(int[] people, int limit) {
		// TODO Auto-generated method stub
		int sumCount=0;
		int count=0;
		Arrays.sort(people);
		int left=0;
		int right=people.length-1;
		while(left<=right) {
			if(people[left]+people[right]<=limit) {
				sumCount++;
				left++;
				right--;
			}
			else {
				right--;
				count++;
			}
			
		}
		return sumCount + count;
		
	}
}