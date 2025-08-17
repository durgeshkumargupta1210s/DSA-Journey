class Solution {
    public List<Integer> partitionLabels(String s) {
      return partitional_level(s);  
    }
    private static List<Integer> partitional_level(String s) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> map=new HashMap<>();
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0; i<s.length(); i++) {
			char ch=s.charAt(i);
		     map.put(ch,i);
		}
		int max=0;
		int prev=-1;
		for(int i=0; i<s.length(); i++) {
			char ch=s.charAt(i);
			max=Math.max(max, map.get(ch));
			if(max==i) {
				list.add(max-prev);
				prev=max;
			}
		}
		
		return list;
	}
}