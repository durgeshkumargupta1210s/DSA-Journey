class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
       return posionedDuration(timeSeries,duration); 
    }
    private static int posionedDuration(int[] t, int d) {
		// TODO Auto-generated method stub
		if (t.length == 0) return 0;

        int totalDuration = 0;
        for (int i = 0; i < t.length - 1; i++) {
            totalDuration += Math.min(d, t[i + 1] - t[i]);
        }
        
        // Add the duration for the last attack
        return totalDuration + d;
    }
}