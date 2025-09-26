class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        if(n==0)return 0;

        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int [] prev=points[0];
        int count=1;

        for(int current=1; current<n; current++){

            int currStart=points[current][0];
            int currEnd=points[current][1];

            int prevStart=prev[0];
            int prevEnd=prev[1];

            if(currStart>prevEnd){// no overlapping
                count++;
                prev=points[current];
            }
            else{ // overlapping
              prev[0]=Math.max(prevStart,currStart);// setting start of intervel
              prev[1]=Math.min(prevEnd,currEnd); // setting end of interval
            }



        }
        return count;

        
    }
}