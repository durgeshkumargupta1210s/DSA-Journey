class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : nums){
            pq.add(ele);
        }
        while(!pq.isEmpty()){
            int rv=pq.poll();
            k--;
            if(k==0){
                return rv;
            }
        }
        return nums.length;
        
    }
}