class Solution {
    public String reverseWords(String s) {
        return reverse_word(s);
    }
    private static String reverse_word(String s) {
		// TODO Auto-generated method stub
		String[] temp= s.split(" ");
		for(int i=0; i<temp.length; i++) {
		       temp[i]=reverse(temp[i]);
			
		}
		return String.join(" ", temp);
	}

	private static String reverse(String str) {
		// TODO Auto-generated method stub
		char [] s=str.toCharArray();
		int left=0;
		int right=s.length-1;
		while(left<right) {
			char tem=s[left];
			s[left]=s[right];
			s[right]=tem;
			left++;
			right--;
		}
		return new String(s);
	}
}