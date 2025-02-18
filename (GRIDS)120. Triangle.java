// with space optimization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }
        

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i).get(j) + dp[j];
                int diagonal = triangle.get(i).get(j) + dp[j + 1];
                dp[j] = Math.min(down, diagonal);
            }
        }
        
        return dp[0];
    }
}
// tabulation
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            } 
        }
        
        return dp[0][0];
    }
}

// memorization
class Solution {
    int n;
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        int[][] dp = new int[n][n];
        return helper(0,0,triangle,dp);
    }
    public int helper(int i ,int j,List<List<Integer>> triangle,int[][] dp){
        if ( i == n-1){
            return triangle.get(n-1).get(j);
        }
        if ( dp[i][j] != 0){
            return dp[i][j];
        }
        int down = triangle.get(i).get(j) + helper(i+1,j,triangle,dp);
        int diagonal = triangle.get(i).get(j) + helper(i+1,j+1,triangle,dp);

        dp[i][j] =  Math.min(down,diagonal);
        return dp[i][j];
    }
}
