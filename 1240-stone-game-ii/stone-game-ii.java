class Solution {

    public int stoneGameII(int[] piles) {
        int [][][]dp=new int[2][101][101];
        for(int [][] aa : dp){
            for(int [] a: aa){
                Arrays.fill(a,-1);
            }
        }
        return solve(piles, 1, 0, 1, dp);
    }

    public static int solve(int[] piles, int person, int idx, int m, int [][][]dp) {

        if (idx >= piles.length) {
            return 0;
        }

        if(dp[person][idx][m]!=-1){
            return dp[person][idx][m];
        }

        int result = (person == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int stone = 0;

        for (int x = 1; x <= Math.min(2 * m, piles.length - idx); x++) {

            stone += piles[idx + x - 1];

            if (person == 1) {
                // Alice maximizes her score
                result = Math.max(result,
                        stone + solve(piles, 0, idx + x, Math.max(m, x), dp));
                dp[person][idx][m]=result;
            } else {
                // Bob minimizes Alice's score
                result = Math.min(result,
                        solve(piles, 1, idx + x, Math.max(m, x), dp));
                dp[person][idx][m]=result;
            }
        }

        return dp[person][idx][m];
    }
}