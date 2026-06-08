class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> small=new ArrayList<>();
        ArrayList<Integer> large=new ArrayList<>();
        ArrayList<Integer> equal=new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i]<pivot){
                small.add(nums[i]);
            }

            else if(nums[i] > pivot){
                large.add(nums[i]);
            }

            else{
                equal.add(nums[i]);
            }

        }

        int count=0;
        int c=0;
        while(count<nums.length && c<small.size()){
            nums[count]=small.get(c);
            count++;
            c++;
        }

        c=0;

        while(count<nums.length && c<equal.size()){
            nums[count]=equal.get(c);
            count++;
            c++;
        }
        c=0;
        while(count<nums.length && c<large.size()){
            nums[count]=large.get(c);
            count++;
            c++;
        }

        return nums;


        
    }
}