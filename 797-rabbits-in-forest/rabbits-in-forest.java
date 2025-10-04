class Solution {
    public int numRabbits(int[] arr) {
        HashMap<Integer, Integer>map=new HashMap<>();

        for(int i=0; i<arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int count=0;

        for(int ele : map.keySet()){
            int size=ele+1;
            int groups=(int)Math.ceil(map.get(ele)/(double)size);

            count+=(groups*size);

        }
        return count;

    }
}