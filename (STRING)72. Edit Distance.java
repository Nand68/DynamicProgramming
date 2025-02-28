import java.util.Arrays;

class Solution {
    int n;
    int m;
    int[][] dp;

    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(n - 1, m - 1, word1, word2);
    }

    public int helper(int i, int j, String s, String p) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == p.charAt(j)) {
            return dp[i][j] = helper(i - 1, j - 1, s, p);
        } else {
            int replace = helper(i - 1, j - 1, s, p);
            int delete = helper(i - 1, j, s, p);
            int insert = helper(i, j - 1, s, p);
            return dp[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
        }
    }
}
