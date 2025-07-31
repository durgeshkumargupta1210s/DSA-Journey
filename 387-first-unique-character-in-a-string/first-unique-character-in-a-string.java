class Solution {
    public int firstUniqChar(String s) {
      return charindex(s);  
    }
    private static int charindex(String s) {
		// TODO Auto-generated method stub
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			char chr= s.charAt(i);
			map.put(chr, map.getOrDefault(chr,0)+1);
		}
	for(int i=0; i<s.length(); i++) {
		char ch= s.charAt(i);
		if(map.get(ch)==1) {
			return i;
		}
	}
	return -1;
    }

}