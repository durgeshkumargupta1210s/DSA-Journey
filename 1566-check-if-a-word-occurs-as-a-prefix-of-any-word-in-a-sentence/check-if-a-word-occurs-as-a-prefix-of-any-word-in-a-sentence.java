class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
       return indexfound(sentence,searchWord);
    }
    public static int  indexfound(String sentence, String searchWord) {
		// TODO Auto-generated method stub
		int index=-1;
		int n=searchWord.length();
		String[] str=sentence.split(" ");
		for(int i=0; i<str.length; i++) {
			if(str[i].length()>=n) {
				String s=str[i].substring(0,n) ;
				if(s.equals(searchWord)) {
					index=i+1;
					break;
				}
			}
			
		}
		return index;
		
	}
}