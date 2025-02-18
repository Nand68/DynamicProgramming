class Solution {
    public int uniquePaths(int m, int n) {
        return solve(m-1,n-1);
    }
    public int solve(int m , int n){
        if( m == 0 && n == 0){
            return 1;
        }
        if( m < 0 || n < 0){
            return 0;
        }
        return solve(m,n-1) + solve(m-1,n);

    }
}

// now to add dp we have to do index++ to handle -1 situation
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(m,n,dp);
    }
    public int solve(int m , int n, int[][] dp){
        if( m == 1 && n == 1){
            dp[m][n] = 1;
            return 1;
        }
        if( m == 0 || n == 0){
            dp[m][n] = 0;
            return 0;
        }
        if( dp[m][n] != -1){
            return dp[m][n];
        }
        dp[m][n] = solve(m,n-1,dp) + solve(m-1,n,dp);

        return dp[m][n];
    }
}
// bottom up approach

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if ( i == 1 && j == 1){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j]; 
                }
            }
        }
        return dp[m][n];
    }
}


// space optimization
class Solution {
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m+1][n+1];
        int[] prev = new int[n+1];
        for(int i = 1; i < m+1; i++){
            int[] cur = new int[n+1];
            for(int j = 1; j < n+1; j++){
                if(i==0 || j==0){
                    cur[j] = 0;
                }
                else if ( i == 1 && j == 1){
                    cur[j] = 1;
                }
                else{
                    cur[j] = cur[j-1] + prev[j]; 
                }
            }
            prev = cur;
        }
        return prev[n];
    }
}




