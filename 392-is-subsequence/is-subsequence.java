class Solution {
    public boolean isSubsequence(String s, String t) {
       return subseqfound(s,t) ;
    }

    public static boolean subseqfound(String s, String t) {
		// TODO Auto-generated method stub
		int i=0; // for s
		int j=0; // for t
		while(i<s.length() && j<t.length()) {
			if(((t.charAt(j)-s.charAt(i)+26)%26==0)) {
				i++;
			}
			j++;
		}
		return i==s.length();
	}

}