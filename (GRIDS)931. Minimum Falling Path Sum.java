 // space optimize
class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[] prev = new int[m];
        int[] curr = new int[m];
        for (int j = 0; j < m; j++) {
            prev[j] = arr[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = prev[j];
                int leftDiag = (j > 0) ? prev[j - 1] : (int) 1e9;
                int rightDiag = (j < m - 1) ? prev[j + 1] : (int) 1e9;

                curr[j] = arr[i][j] + Math.min(up, Math.min(leftDiag, rightDiag));
            }
            
            prev = curr.clone();
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, prev[j]);
        }

        return minSum;
    }
}

// tabulation
class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        
        int[][] dp = new int[n][m];
        
        for (int j = 0; j < m; j++) {
            dp[0][j] = arr[0][j];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = dp[i - 1][j];
                int leftDiag = (j > 0) ? dp[i - 1][j - 1] : (int) 1e9;
                int rightDiag = (j < m - 1) ? dp[i - 1][j + 1] : (int) 1e9;
                
                dp[i][j] = arr[i][j] + Math.min(up, Math.min(leftDiag, rightDiag));
            }
        }
        
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }
        
        return minSum;
    }
}

// memorization

class Solution {
    int n, m;
    int[][] memo;

    public int minFallingPathSum(int[][] arr) {
        n = arr.length;
        m = arr[0].length;
        memo = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, dp(arr, n - 1, j));
        }
        return minSum;
    }

    public int dp(int[][] arr, int i, int j) {
        if (j < 0 || j >= m) return (int) 1e9;
        if (i == 0) return arr[i][j];

        if (memo[i][j] != Integer.MAX_VALUE) return memo[i][j];

        int up = dp(arr, i - 1, j);
        int leftDiag = dp(arr, i - 1, j - 1);
        int rightDiag = dp(arr, i - 1, j + 1);

        return memo[i][j] = arr[i][j] + Math.min(up, Math.min(leftDiag, rightDiag));
    }
}
