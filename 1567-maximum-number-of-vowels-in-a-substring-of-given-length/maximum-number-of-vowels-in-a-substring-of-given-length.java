class Solution {
    public int maxVowels(String s, int k) {
        return countvowel(s,k);
    }
    public static int countvowel(String s, int k) {
		// TODO Auto-generated method stub
		int count=0, ans=0,si=0,ei=0;
		for(int i=0; i<k; i++) {
			char ch=s.charAt(i);
			if(ch=='a'|| ch=='e' || ch=='i' || ch=='o'|| ch=='u') {
				count++;
			}
		}
		ans=count;
		for( int i=k; i<s.length(); i++ ) {
			// growing phase
			char ch=s.charAt(i);
			
			if(ch=='a'|| ch=='e' || ch=='i' || ch=='o'|| ch=='u') {
				count++;
			}
			// shrinking phase
			char ch1=s.charAt(i-k);
			if(ch1=='a'|| ch1=='e' || ch1=='i' || ch1=='o'|| ch1=='u') {
				count--;
			}
			// answer updation
			ans=Math.max(ans, count);
		}
		
		return ans;
	}
}