class Solution {
    public int[] shortestToChar(String s, char c) {
        int [] arr=new int [s.length()];
        List<Integer>list=new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                list.add(i);
            }
        }
        for(int i=0; i<s.length(); i++){
            int ans=Integer.MAX_VALUE;
            for(int num : list){
                int dist=Math.abs(num-i);
                ans=Math.min(ans,dist);
            }

            arr[i]=ans;

        }

        return arr;
        
    }
}