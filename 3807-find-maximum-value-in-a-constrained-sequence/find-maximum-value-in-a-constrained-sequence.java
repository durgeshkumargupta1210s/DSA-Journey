class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {

        long[] limit=new long[n];
        Arrays.fill(limit,Long.MAX_VALUE);

        limit[0]=0;

        for(int[]r : restrictions){
            int idx=r[0];
            int val=r[1];
            limit[idx]=Math.min(limit[idx],val);
        }

        for(int i=1; i<n; i++){
            limit[i]=Math.min(limit[i],limit[i-1]+diff[i-1]);
        }

         for(int i=n-2; i>=0; i--){
            limit[i]=Math.min(limit[i],limit[i+1]+diff[i]);
        }

        long ans=0;
        for(long val: limit){
            ans=Math.max(ans,val);
        }

        return (int) ans;
        
    }
}