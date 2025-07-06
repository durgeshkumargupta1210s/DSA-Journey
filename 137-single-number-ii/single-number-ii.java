class Solution {
    public int singleNumber(int[] nums) {
        return singlehu(nums);
    }
    public static int singlehu(int[] nums) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int ele : nums) {
			map.put(ele, map.getOrDefault(ele,0)+1);
			
		}
		int ans=0;
		for(Map.Entry<Integer,Integer> e: map.entrySet()) {
			 if(e.getValue()==1) {
				 ans=e.getKey();
			 }
		}
		
		return ans ;
	}
}