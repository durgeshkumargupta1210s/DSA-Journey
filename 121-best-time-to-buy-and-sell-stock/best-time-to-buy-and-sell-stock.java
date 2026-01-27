class Solution {

    // Function to calculate the maximum profit from one buy and one sell
    public int maxProfit(int[] prices) {

        // min stores the minimum stock price encountered so far
        int min = Integer.MAX_VALUE;

        // maxprofit stores the maximum profit possible till now
        int maxprofit = 0;

        // Traverse through each day's stock price
        for (int i = 0; i < prices.length; i++) {

            // Update the minimum price if a smaller price is found
            // This represents the best day to buy so far
            min = Math.min(min, prices[i]);

            // Calculate profit if we sell on current day
            int profit = prices[i] - min;

            // Update maxprofit if current profit is greater
            // This represents the best day to sell so far
            maxprofit = Math.max(maxprofit, profit);
        }

        // Return the maximum profit achieved
        return maxprofit;
    }
}
