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
