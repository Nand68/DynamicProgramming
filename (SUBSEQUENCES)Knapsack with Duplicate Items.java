
class Solution {
    static int[][] dp;

    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        dp = new int[n][capacity + 1];

        // Initialize DP table with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Solve for the last item index
        return knapSackHelper(n - 1, capacity, val, wt);
    }
    
    
    static int knapSackHelper(int i, int capacity, int val[], int wt[]) {
        // Base Case: If there are no items left or capacity is 0
        if (i == 0) {
            return (capacity / wt[0]) * val[0]; // Take as many as possible from the first item
        }
        
        // If already computed, return the stored value
        if (dp[i][capacity] != -1) {
            return dp[i][capacity];
        }

        // Case 1: Exclude the current item
        int exclude = knapSackHelper(i - 1, capacity, val, wt);

        // Case 2: Include the current item (only if weight allows)
        int include = 0;
        if (wt[i] <= capacity) {
            include = val[i] + knapSackHelper(i, capacity - wt[i], val, wt);
        }

        // Store and return the maximum value
        return dp[i][capacity] = Math.max(exclude, include);
    }
}
