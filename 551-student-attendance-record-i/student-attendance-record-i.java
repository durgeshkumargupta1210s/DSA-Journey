class Solution {
    public boolean checkRecord(String s) {
      return record(s) ; 
    }
    public static boolean record(String s) {
		// TODO Auto-generated method stub
		int c=0;// late
		int f=0;// absentees
		for(int i=0; i<s.length(); i++) {
			
			if(s.charAt(i)=='A') {
				f++;
				if(f>=2) {
					return false;
				}
			}	
			
			if(s.charAt(i)=='L') {
				c++;
				if(c>=3) {
					return false;
				}
			}
			else {
				c=0;
			}
		}
		return true;
		}
}