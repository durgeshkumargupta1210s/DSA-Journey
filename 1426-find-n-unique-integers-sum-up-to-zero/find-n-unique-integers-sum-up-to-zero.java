import java.util.*;

class Solution {
    public int[] sumZero(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        if (n % 2 == 0) {
            for (int i = 1; i <= n; i += 2) {
                list.add(-i);
                list.add(i);
            }
        } else {

            for (int i = 1; i < n; i += 2) { 
                list.add(-i);
                list.add(i);
            }
            list.add(0);
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
