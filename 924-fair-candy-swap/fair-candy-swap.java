class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        return failCandiSwap(aliceSizes,bobSizes);
    }
    private static int [] failCandiSwap(int[] a, int[] b) {
		// TODO Auto-generated method stub
		int sumA=0;
		int sumB=0;
		for(int item:a) {
			sumA+=item;
		}
		for(int item:b) {
			sumB+=item;
		}
		int diff=(sumA-sumB)/2;
		HashSet<Integer> setB=new HashSet<>();
		for(int item: b) {
			setB.add(item);
		}
		for(int item:a) {
			if(setB.contains(item-diff)) {
				return new int[]{item,item-diff};
			}
		}
		
		return new int[] {-1,-1};
	}
}