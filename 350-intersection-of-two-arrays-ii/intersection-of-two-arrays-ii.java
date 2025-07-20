class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        return intersection_array(nums1,nums2);
    }
   private static int[] intersection_array(int[] nums1, int[] nums2) {
		// TODO Auto-generated method stub
		 Map<Integer, Integer> map = new HashMap<>();
	        List<Integer> result = new ArrayList<>();
	        
	        for (int ele : nums1) {
	            map.put(ele, map.getOrDefault(ele, 0) + 1);
	        }
	        
	        for (int num : nums2) {
	            if (map.containsKey(num) && map.get(num) > 0) {
	                result.add(num);
	                map.put(num, map.get(num) - 1); 
	            }
	        }
	     
	        int[] temp = new int[result.size()];
	        for (int i = 0; i < result.size(); i++) {
	            temp[i] = result.get(i);
	        }
	        
	        return temp;
	}
}