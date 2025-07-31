class Solution {
    public char findTheDifference(String s, String t) {
      return elementFound(s,t);  
    }
    private static char elementFound(String s, String t) {
		// TODO Auto-generated method stub
		int sum1=0;
		int sum2=0;
		for(int i=0; i<t.length(); i++) {
			char ch1=t.charAt(i);
			sum1=sum1+ch1;
		}
		for(int i=0; i<s.length(); i++) {
			char ch2=s.charAt(i);
			sum2=sum2+ch2;
		}
		char ch= (char)(sum1-sum2);
		return ch;
	}

}