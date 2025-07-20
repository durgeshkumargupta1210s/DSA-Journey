class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        return intersection_array(nums1,nums2);
    }
    private static int[]  intersection_array(int[] nums1, int[] nums2) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al=new ArrayList<>();
		HashSet<Integer> set1=new HashSet<>();
		HashSet<Integer> set2=new HashSet<>();
		for(int ele:nums1) {
			set1.add(ele);
		}
		for(int ele:nums2) {
			set2.add(ele);
		}
		for(int ele : set1) {
			if(set2.contains(ele)) {
				al.add(ele);
			}
		}
		int [] temp=new int[al.size()];
         for(int i=0; i<al.size(); i++) {
        	temp[i]=al.get(i); 
         }
         return temp;
	}
}