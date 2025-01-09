class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return solve(n-1,m-1,text1,text2);
    }
    public int solve(int i , int j ,String text1, String text2 ){
        if( i < 0 || j < 0){
            return 0;
        }
        if ( text1.charAt(i) == text2.charAt(j) ){
            return 1 + solve(i-1,j-1,text1,text2);
        }
        else{
            int left = solve(i-1,j,text1,text2);
            int right = solve(i,j-1,text1,text2);
            return Math.max(left,right);
        }
    }
}

// using memo

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        return solve(n-1,m-1,text1,text2,dp);
    }
    public int solve(int i , int j ,String text1, String text2, int[][] dp){
        if( i < 0 || j < 0){
            return 0;
        }
        if( dp[i][j] != 0){
            return dp[i][j];
        }
        if ( text1.charAt(i) == text2.charAt(j) ){
            dp[i][j] =  1 + solve(i-1,j-1,text1,text2,dp);
            return dp[i][j];
        }
        else{
            int left = solve(i-1,j,text1,text2,dp);
            int right = solve(i,j-1,text1,text2,dp);
            dp[i][j] = Math.max(left,right);
            return  dp[i][j];
        }
    }
}
