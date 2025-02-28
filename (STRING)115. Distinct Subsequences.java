import java.util.*;

class Solution {
    int n;
    int m;
    int[][] dp;
    
    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(n - 1, m - 1, s, t);
    }
    
    public int helper(int i, int j, String s, String p) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == p.charAt(j)) {
            return dp[i][j] = helper(i - 1, j - 1, s, p) + helper(i - 1, j, s, p);
        } else {
            return dp[i][j] = helper(i - 1, j, s, p);
        }
    }
}

// tabulation

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        
         for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][m];
    }
}



