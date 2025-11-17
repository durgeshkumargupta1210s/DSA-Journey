class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prevOne = - (k + 1);   // ensures first '1' passes the check
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 1) {
            if (i - prevOne - 1 < k) {
                return false;
            }
            prevOne = i;
        }
    }
    return true;
        
    }
}