class Solution {
    public int[] separateDigits(int[] nums) {
        String str="";
        for(int i=0; i<nums.length; i++){
            str+=nums[i];
        }

        int[]arr=new int[str.length()];
        for(int i=0; i<str.length(); i++){
            arr[i]=str.charAt(i)-'0';
        }
        return arr;
        
    }
}