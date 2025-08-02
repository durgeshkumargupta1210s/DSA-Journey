class Solution {
    public boolean detectCapitalUse(String word) {
        return detectcapital(word);
    }
    public  static boolean detectcapital(String str) {
		// TODO Auto-generated method stub
		if(str.equals(str.toLowerCase())) {
			return true;
		}
		else if(str.equals(str.toUpperCase())) {
			return true;
		}
		String substr=str.substring(1);
		if(Character.isUpperCase(str.charAt(0)) && substr.equals(substr.toLowerCase())) {
			return true;
		}
		else {
			return false;
		}
		
	}
}