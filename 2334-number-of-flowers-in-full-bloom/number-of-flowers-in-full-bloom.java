class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] start=new int [flowers.length];
        int [] end=new int[flowers.length];
        int [] ans=new int [people.length];

        for(int i=0; i<flowers.length; i++){
            start[i]=flowers[i][0];
            end[i]=flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for(int i=0; i<people.length; i++){
            int time=people[i];

            int flowerStart=upperBound(start,time);
            int flowerEnd=upperBound(end,time-1);

            ans[i]=flowerStart-flowerEnd;
        }

        return ans;


        
    }
    public int upperBound(int [] arr, int target){
        int idx=Arrays.binarySearch(arr, target);

        if(idx>=0){
            while(idx<arr.length && arr[idx]<=target) idx++;
        }
        else{
            idx=-(idx+1);
        }
        return idx;
    }
}