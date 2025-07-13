class Solution {
    public void reverseString(char[] s) {
        reverse(s);
    }
    private static void reverse(char [] s) {
		// TODO Auto-generated method stub
		int left=0;
		int right=s.length-1;
		while(left<right) {
			char  temp=s[left];
			s[left]=s[right];
			s[right]=temp;
			left++;
			right--;
		}
	}
}