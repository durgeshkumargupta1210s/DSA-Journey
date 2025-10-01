class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(b[0],a[0]);
        });

        List<int[]> list=new ArrayList<>();

        for(int[] arr : people){
            int height=arr[0];
            int k=arr[1];

            list.add(k,arr);
        }


        return list.toArray(new int[people.length][2]);
        
    }
}