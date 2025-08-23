class Solution {
    public boolean canConstruct(String s, int k) {
        return canconstruct(s,k);
    }
    public static boolean canconstruct(String s, int k) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> map =new HashMap<>();
		for(char ch: s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch,0)+1);
		}
		if(s.length()<k) {
			return false;
		}
		int odd=0;
		for(int ele : map.values()) {
			if(ele%2!=0) {
				odd++;
			}
		}
		if(odd<=k) {
			return true;
		}
		else {
			return false;
		}
	}
}