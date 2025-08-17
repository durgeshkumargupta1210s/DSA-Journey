class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        return greaterthantarget(letters,target) ;
    }
    private static char greaterthantarget(char[] letters, char target) {
		// TODO Auto-generated method stub
		int lo=0;
		int hi=letters.length-1;
		char ans=letters[0];
		while(lo<=hi) {
			int mid=(lo+hi)/2;
			if(letters[mid]>target) {
				ans=letters[mid];
				hi=mid-1;
			}
			else {
				lo=mid+1;
			}
		}
		return ans;
		
	}
}