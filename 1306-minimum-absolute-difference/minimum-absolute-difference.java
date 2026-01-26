class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++){
            int diff=Math.abs(arr[i+1]-arr[i]);
            min=Math.min(min,diff);
        }

        ArrayList<List<Integer>> result=new ArrayList<>();
        for(int i=0; i<arr.length-1; i++ ){
            List<Integer> list=new ArrayList<>();
            if(arr[i+1]-arr[i]==min){
                list.add(arr[i]);
                list.add(arr[i+1]);
                result.add(list);
            }
        }

        return result;
        
    }
}