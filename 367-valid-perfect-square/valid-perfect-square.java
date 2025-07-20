class Solution {
    public boolean isPerfectSquare(int num) {
       return isfound(num) ;
    }
     public static boolean isfound(int num) {
        if (num < 2) {
            return num == 1; 
        }

        int lo = 2; 
        int hi = num / 2 + 1; 
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long square = (long) mid * mid; 
            if (square == num) {
                return true;
            } else if (square > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}