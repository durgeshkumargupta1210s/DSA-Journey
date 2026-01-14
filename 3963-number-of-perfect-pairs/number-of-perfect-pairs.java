class Solution {
    public long perfectPairs(int[] arr) {
        int n=arr.length;
        
        for(int i=0; i<n; i++){
            arr[i]=Math.abs(arr[i]);
        }

        Arrays.sort(arr);

        long count=0;
        int j=0;

        for(int i=0; i<n; i++){
            if(j<i+1){
                j=i+1;
            }

            while(j<n && arr[j]<=2*arr[i]){
                j++;
            }

            count+=(j-i-1);
        }

        return count;

    }
}