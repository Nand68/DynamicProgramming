// using memo

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) { 
            Arrays.fill(dp[i], -1); 
        }
        return solve(n,m,text1,text2,dp);
    }
    public int solve(int i , int j ,String text1, String text2, int[][] dp){
        if( i == 0 || j == 0){
            dp[i][j] = 0;
            return 0;
        }
        if( dp[i][j] != -1){
            return dp[i][j];
        }
        if ( text1.charAt(i-1) == text2.charAt(j-1) ){
            dp[i][j] =  1 + solve(i-1,j-1,text1,text2,dp);
        }
        else{
            int left = solve(i-1,j,text1,text2,dp);
            int right = solve(i,j-1,text1,text2,dp);
            dp[i][j] = Math.max(left,right);
        }
        return dp[i][j];
    }
}

// bottom up

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if ( text1.charAt(i-1) == text2.charAt(j-1) ){
                    dp[i][j] =  1 + dp[i-1][j-1]; //solve(i-1,j-1,text1,text2,dp);
                }
                else{
                    int left = dp[i-1][j]; //solve(i-1,j,text1,text2,dp);
                    int right = dp[i][j-1]; //solve(i,j-1,text1,text2,dp);
                    dp[i][j] = Math.max(left,right);
                }
            }
        }
        return dp[n][m];
    }
    // public int solve(int i , int j ,String text1, String text2, int[][] dp){
    //     if( i == 0 || j == 0){
    //         dp[i][j] = 0;
    //         return 0;
    //     }
    //     if( dp[i][j] != -1){
    //         return dp[i][j];
    //     }
    //     if ( text1.charAt(i-1) == text2.charAt(j-1) ){
    //         dp[i][j] =  1 + solve(i-1,j-1,text1,text2,dp);
    //     }
    //     else{
    //         int left = solve(i-1,j,text1,text2,dp);
    //         int right = solve(i,j-1,text1,text2,dp);
    //         dp[i][j] = Math.max(left,right);
    //     }
    //     return dp[i][j];
    // }
}
// space optimization

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // int[][] dp = new int[n+1][m+1];
        int[] prev = new int[m+1];
        prev[0] = 0;
        for(int i = 1; i < n + 1; i++){
            int[] cur = new int[m+1];
            cur[0] = 0;
            for(int j = 1; j < m + 1; j++){
                if ( text1.charAt(i-1) == text2.charAt(j-1) ){
                    cur[j] =  1 + prev[j-1]; //solve(i-1,j-1,text1,text2,dp);
                }
                else{
                    int left = prev[j]; //solve(i-1,j,text1,text2,dp);
                    int right = cur[j-1]; //solve(i,j-1,text1,text2,dp);
                    cur[j] = Math.max(left,right);
                }
            }
            prev = cur;
        }
        return prev[m];
    }
    // public int solve(int i , int j ,String text1, String text2, int[][] dp){
    //     if( i == 0 || j == 0){
    //         dp[i][j] = 0;
    //         return 0;
    //     }
    //     if( dp[i][j] != -1){
    //         return dp[i][j];
    //     }
    //     if ( text1.charAt(i-1) == text2.charAt(j-1) ){
    //         dp[i][j] =  1 + solve(i-1,j-1,text1,text2,dp);
    //     }
    //     else{
    //         int left = solve(i-1,j,text1,text2,dp);
    //         int right = solve(i,j-1,text1,text2,dp);
    //         dp[i][j] = Math.max(left,right);
    //     }
    //     return dp[i][j];
    // }
}
