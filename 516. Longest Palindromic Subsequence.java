// as we know if we reverse string and take lcs then we can get answer here it's direct code with space optimization
class Solution {
    public int longestPalindromeSubseq(String s) {
        String reversedS = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s,reversedS);
    }
    public int longestCommonSubsequence(String text1, String text2){
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
}
