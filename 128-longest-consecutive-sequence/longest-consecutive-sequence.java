class Solution {
    public int longestConsecutive(int[] nums) {
        return longestlen(nums);
    }
    public static int longestlen(int[] nums) {
		// TODO Auto-generated method stub
		HashSet<Integer> h = new HashSet<>();
		for(int ele: nums) {
			h.add(ele);
		}
		int ans=0;
		for(int ele:h) {
			if(!h.contains(ele-1)) {
				int current=ele;
				int count=1;
				while(h.contains(current+1)) {
					count++;
					current++;
				}
				ans=Math.max(ans,count);
			}
		}
		return ans;
		
		
	}
}