class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxAnswer = 0;
        int minValue = prices[0];
        for ( int i = 1; i < n; i++){
            int rem = prices[i] - minValue;
            maxAnswer = Math.max(maxAnswer,rem);
            minValue = Math.min(minValue,prices[i]);
        }
        return maxAnswer;
    }
}
