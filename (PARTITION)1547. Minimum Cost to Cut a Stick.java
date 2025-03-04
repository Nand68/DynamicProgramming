import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        list.add(0);  // Start of the stick
        for (int cut : cuts) {
            list.add(cut);  // Add each cut
        }
        list.add(n);  // End of the stick
        Collections.sort(list);  // Sort the cut positions

        // Memoization table
        int[][] dp = new int[list.size()][list.size()];

        return helper(0, list.size() - 1, list, dp);
    }

    private int helper(int i, int j, List<Integer> list, int[][] dp) {
        // Base case: no cuts to make
        if (i + 1 >= j) return 0;
        
        // If already computed, return the stored value
        if (dp[i][j] != 0) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            // Calculate the cost of making the cut at position k
            int cost = list.get(j) - list.get(i) + helper(i, k, list, dp) + helper(k, j, list, dp);
            min = Math.min(min, cost);
        }
        
        // Store the result in the dp table
        dp[i][j] = min;
        return min;
    }
}
