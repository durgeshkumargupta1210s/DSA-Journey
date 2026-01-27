class Solution {

    // Function to calculate maximum profit with unlimited transactions
    public int maxProfit(int[] prices) {

        // Variable to store total profit
        int profit = 0;

        // Traverse through stock prices starting from day 1
        for (int i = 1; i < prices.length; i++) {

            // If today's price is greater than yesterday's price
            // then we can make profit by buying yesterday and selling today
            if (prices[i] > prices[i - 1]) {

                // Add the profit of this transaction
                profit += prices[i] - prices[i - 1];
            }
        }

        // Return total accumulated profit
        return profit;
    }
}
