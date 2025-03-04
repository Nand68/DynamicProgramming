
class Solution {
    static int[][] dp;
    
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        dp = new int[n][n];
        
        // Initialize dp table with -1 (indicating that no subproblem is solved yet)
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return helper(1, n - 1, arr, dp);
    }
    
    static int helper(int i, int j, int[] arr, int[][] dp) {
        // Base case: no cost if there is only one matrix
        if (i == j) return 0;
        
        // If already computed, return the result from dp
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int min = Integer.MAX_VALUE;
        
        // Try different split points to minimize the multiplication cost
        for (int k = i; k < j; k++) {
            int step = (arr[i - 1] * arr[k] * arr[j]) // cost of multiplying matrices i-1, i..k, k+1..j
                    + helper(i, k, arr, dp)   // recursively solve for matrices i..k
                    + helper(k + 1, j, arr, dp); // recursively solve for matrices k+1..j
            
            min = Math.min(min, step);
        }
        
        dp[i][j] = min; // Store the result for the subproblem
        return dp[i][j];
    }
    
}
