class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int ele: nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int maxFreq=Integer.MIN_VALUE;
        int count=0;
        for(int ele : map.values()){
            if(maxFreq<=ele){
                maxFreq=ele;
            }
        }
        for(int ele : map.values()){
            if(maxFreq==ele){
                count++;
            }
        }
        return maxFreq*count;

        
    }
}