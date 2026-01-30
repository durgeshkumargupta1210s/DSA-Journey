class Solution {
    int[] pre;
    Integer[] dp;
    int k;
    int n;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        this.k = k;
        this.n = n;
        pre = new int[n];
        dp = new Integer[1 << n];

        // ---  Graph Construction ---
        for (int[] rel : relations) {
            int prev = rel[0] - 1;
            int next = rel[1] - 1;
            pre[next] |= (1 << prev); // "Next" depends on "Prev"
        }

        int start = 0;
        for (int i = 0; i < n; i++) start |= (1 << i);
        
        return f(start);
    }

    public int f(int mask) {
        if (mask == 0) return 0;
        if (dp[mask] != null) return dp[mask];

        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // Check if i is in mask AND all its prereqs are NOT in mask (already taken)
            if ((mask & (1 << i)) != 0 && (pre[i] & mask) == 0) {
                available.add(i);
            }
        }

       
        
        int min = Integer.MAX_VALUE;
        if (available.size() > k) {
            List<Integer> combs = new ArrayList<>();
            generateMasks(combs, available, mask, k, 0);//generate combs
            for (int m : combs) {
                min = Math.min(min, 1 + f(m));
            }
        } else {
            int temp = mask;
            for (int i : available) {
                temp = (1 << i) ^ temp; 
            }
            min = 1 + f(temp);
        }
        return dp[mask] = min;
    }
//generating each possible mask/way where we can pick next k numbers from current state 
    public void generateMasks(List<Integer> combs, List<Integer> available, int mask, int k, int currentIndex) {
        if (k == 0) {
            combs.add(mask);
            return;
        }
         for (int i = currentIndex; i < available.size(); i++) {
            int tmask = (1 << (available.get(i))) ^ mask;
            generateMasks(combs, available, tmask, k - 1, i + 1);
        }
    }
}