class Solution {
    int [][]job;
    int [] dp;
    int n;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n=startTime.length;

        job=new int[n][3];

        for(int i=0; i<job.length; i++){
           job[i][0]=startTime[i];
           job[i][1]=endTime[i];
           job[i][2]=profit[i];
        }

        Arrays.sort(job,(a,b)-> a[0]-b[0]);

        dp=new int[n];
        Arrays.fill(dp, -1);

        return maximumProfit(0);

        
    }
    public int maximumProfit(int i){
        if(i>=n){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int notTake=maximumProfit(i+1);
        int nextidx=binarySearch(job[i][1]);

        int take=job[i][2]+maximumProfit(nextidx);

        return dp[i]= Math.max(take,notTake);
    }
    public int binarySearch(int target){
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(job[mid][0]>=target){
              ans=mid;
              high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}