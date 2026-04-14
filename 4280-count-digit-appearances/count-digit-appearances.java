class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans=0;

        for(int i:nums){
            String s=Integer.toString(i);
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)-'0'==digit){
                    ans++;
                }
            }
        }

        return ans;
    }
}