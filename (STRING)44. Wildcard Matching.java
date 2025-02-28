class Solution {
    int n, m;
    Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        n = s.length();
        m = p.length();
        dp = new Boolean[n + 1][m + 1]; 
        return helper(n, m, s, p);
    }

    private boolean helper(int i, int j, String s, String p) {
        if (i == 0 && j == 0) return true;
        if (j == 0) return false;
        if (i == 0) {
            for (int k = 0; k < j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }


        if (dp[i][j] != null) return dp[i][j];

        boolean result;
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            result = helper(i - 1, j - 1, s, p);
        } else if (p.charAt(j - 1) == '*') {
            result = helper(i - 1, j, s, p) || helper(i, j - 1, s, p);
        } else {
            result = false;
        }

        dp[i][j] = result;
        return result;
    }
}


// tabulation
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[n][m];
    }
}
