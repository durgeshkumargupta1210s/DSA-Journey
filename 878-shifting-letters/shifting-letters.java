class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        return aftershift(s,shifts);
    }
    private static String aftershift(String s, int[] shifts) {
		// TODO Auto-generated method stub
		StringBuilder result = new StringBuilder();
		int sum=0;
		
		int []temp=new int[shifts.length];
		for(int i=shifts.length-1;i>=0; i--) {
			sum=(sum+shifts[i])%26;
			temp[i]=sum;
		}
		for(int i=0; i<temp.length;i++) {
			int t=(s.charAt(i)-'a'+temp[i])%26+'a';
			result.append((char)t);
		}
		return result.toString();
		
	}
}