class Solution {
    int n;
    int m;
    int[] nrow = {-1,0,1};
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][m];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1); 
            }
        }
        return helper(0,0,m-1,n,m,grid,dp);
    }
    public int helper(int i,int j1,int j2,int n,int m,int[][] grid,int[][][] dp){
        if( j1 < 0 || j1 >= m || j2 < 0 || j2 >= m){
            return (int) -1e8;
        }
        if ( i == n-1){
            if ( j1 == j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        if ( dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        int max = (int) -1e8;
        for (int dj1 = -1; dj1 <= 1; dj1++){
            for (int dj2 = -1; dj2 <= 1; dj2++){
                int value = 0;
                if( j1 == j2){
                    value += grid[i][j1];
                }
                else{
                    value = grid[i][j1] + grid[i][j2];
                }
                value += helper(i+1,j1+dj1,j2+dj2,n,m,grid,dp);
                max = Math.max(value,max);
            }
        }
        return dp[i][j1][j2] = max;
    }
}
