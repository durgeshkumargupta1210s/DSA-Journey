class Solution {
public int distMoney(int money, int children) {
        int extra = money - children;
        if (extra < 0) return -1;
        if (extra == 0) return 0;
        int fullSevenBundles = extra / 7;   // how many children wecan turn into $8 (candidate)
        int leftover = extra % 7;           // extra money still left after giving those +7's
        if (fullSevenBundles > children) {
            return children - 1;
        }
       
        else if (fullSevenBundles == children) {
            if (leftover == 0) return children;
            return children - 1;
        }
        else {
           
            if (leftover == 3 && fullSevenBundles == children - 1) {
                return children - 2;
            }
            return fullSevenBundles;
        }
    }
};