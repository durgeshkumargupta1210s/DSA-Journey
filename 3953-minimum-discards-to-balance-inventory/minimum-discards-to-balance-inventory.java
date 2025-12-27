import java.util.*;

class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int n = arrivals.length;
        int discards = 0;
        
      
        int[] freq = new int[100001];
        
      
        boolean[] kept = new boolean[n];

        for (int i = 0; i < n; i++) {
            int itemType = arrivals[i];

           
            if (i >= w) {
                int oldIndex = i - w;
                if (kept[oldIndex]) {
                    freq[arrivals[oldIndex]]--;
                }
            }

          
            if (freq[itemType] < m) {
                // Keep the item
                freq[itemType]++;
                kept[i] = true;
            } else {
                // Discard the item
                discards++;
                kept[i] = false;
            }
        }

        return discards;
    }
}