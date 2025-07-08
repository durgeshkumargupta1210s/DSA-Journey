class Solution {
    public int hIndex(int[] citations) {
        return indexfound(citations);
    }
    public static int  indexfound(int[] ci) {
		// TODO Auto-generated method stub
		Arrays.sort(ci);
		int count=0;
		int lo=0;
		int hi=ci.length-1;
		while(lo<=hi) {
			int mid=(lo+hi)/2;
			int h=ci.length-mid;
			if(h<=ci[mid]) {
				count=h;
 				hi=mid-1; // for higher index 
			}
			else {
				lo=mid+1;
			}
			
			
		}
		
		return count;
    }
}