import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3]; 
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0, 0, 2, prices, dp);
    }

    public int helper(int i, int buy, int cap, int[] prices, int[][][] dp) {
        if (cap == 0 || i == prices.length) {
            return 0;
        }
        if (dp[i][buy][cap] != -1) {
            return dp[i][buy][cap];
        }
        
        int profit = 0;
        if (buy == 0) {  // Buying allowed
            int op1 = helper(i + 1, 0, cap, prices, dp);  // Skip buying
            int op2 = -prices[i] + helper(i + 1, 1, cap, prices, dp); // Buy stock
            profit = Math.max(op1, op2);
        } else {  // Selling allowed
            int op1 = helper(i + 1, 1, cap, prices, dp);  // Skip selling
            int op2 = prices[i] + helper(i + 1, 0, cap - 1, prices, dp); // Sell stock
            profit = Math.max(op1, op2);
        }
        
        return dp[i][buy][cap] = profit;
    }
}
