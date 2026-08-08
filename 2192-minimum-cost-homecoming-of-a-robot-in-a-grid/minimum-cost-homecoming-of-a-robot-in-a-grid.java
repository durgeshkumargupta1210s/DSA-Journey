class Solution {

    public int minCost(int[] startPos, int[] homePos,
                       int[] rowCosts, int[] colCosts) {

        return solve(startPos[0], startPos[1],
                     homePos[0], homePos[1],
                     rowCosts, colCosts);
    }

    public static int solve(int cr, int cc, int m, int n,
                            int[] cost1, int[] cost2) {

        if (cr == m && cc == n) {
            return 0;
        }

        if (cr < m) {
            return cost1[cr + 1]
                    + solve(cr + 1, cc, m, n, cost1, cost2);
        }

        if (cr > m) {
            return cost1[cr - 1]
                    + solve(cr - 1, cc, m, n, cost1, cost2);
        }

        if (cc < n) {
            return cost2[cc + 1]
                    + solve(cr, cc + 1, m, n, cost1, cost2);
        }

        return cost2[cc - 1]
                + solve(cr, cc - 1, m, n, cost1, cost2);
    }
}