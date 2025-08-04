class Solution {
    public int distributeCandies(int[] candyType) {
        return types_of_candies(candyType);
    }
    public static int types_of_candies(int[] candyType) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int ele : candyType) {
			map.put(ele,map.getOrDefault(ele,0)+1);
		}
		int n=candyType.length;
		if(map.size()>=n/2) {
			return n/2;
		}
		else {
			return map.size();
		}
	}
}