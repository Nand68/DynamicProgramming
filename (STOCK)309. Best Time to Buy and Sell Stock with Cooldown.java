class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];  
        for (int[] row : dp) {
            Arrays.fill(row, -1); 
        }
        return helper(0, 0, prices, dp);
    }

    public int helper(int i, int buy, int[] prices, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }
        int profit = 0;
        if (buy == 0) {
            int op1 = helper(i + 1, 0, prices, dp);
            int op2 = -prices[i] + helper(i + 1, 1, prices, dp);
            profit = Math.max(op1, op2);
        } else {
            int op1 = helper(i + 1, 1, prices, dp);
            int op2 = prices[i] + helper(i + 2, 0, prices, dp);
            profit = Math.max(op1, op2);
        }
        return dp[i][buy] = profit;
    }
}
