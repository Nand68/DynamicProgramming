class Solution {
    public int change(int amount, int[] coins) {
         int n = coins.length;
        int[] prev = new int[amount+1];
        prev[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            if ((i % coins[0]) == 0) {
                prev[i] = 1;
            } else {
                prev[i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            int[] cur = new int[amount+1];
            for (int j = 0; j < amount + 1; j++) {
                int pick = 0;
                if (coins[i] <= j) {
                    pick = cur[j-coins[i]];
                }

                int notpick = prev[j]; 
                cur[j] = pick + notpick;
            }
            prev = cur;
        }
        int ans = prev[amount]; 
        return ans;
    }
}

// using memo 

class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(n,price,n-1,dp);
    }
    public int solve(int N,int[] price ,int index, int[][] dp){
        if(index == 0){
            dp[index][N] = N*price[index];
            return N*price[index];
        }
        if( dp[index][N] != -1){
            return dp[index][N];
        }
        int pick = 0;
        int curlen = index + 1;
        if ( curlen <= N){
            pick = price[index] + solve(N-curlen,price,index,dp);
        }
        int notpick = solve(N,price,index-1,dp);
         dp[index][N] = Math.max(pick,notpick);
        
        return dp[index][N];
    }
}
