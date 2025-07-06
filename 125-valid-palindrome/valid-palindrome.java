class Solution {
    public boolean isPalindrome(String s) {
        return removespecialcharacter(s);
    }
    private static Boolean removespecialcharacter(String str) {
		// TODO Auto-generated method stub
		String s=str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		 int i = 0;
		 int j= s.length()-1;
		 while(i<j) {
			 if(s.charAt(i)!=s.charAt(j)) {
				 return false;
			 }
			 i++;
			 j--;
			 
		 }
		
		return true;
		
	}
}