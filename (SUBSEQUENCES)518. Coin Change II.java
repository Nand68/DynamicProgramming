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

// bottom up approach 


class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        for(int i = 0; i < n+1; i++){
            dp[0][i] = i*price[0];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n+1; j++){
                    int pick = 0;
                    int curlen = i + 1;
                    if ( curlen <= j){
                        pick = price[i] + dp[i][j-curlen]; // solve(j-curlen,price,i,dp);
                    }
                    int notpick = dp[i-1][j]; //solve(j,price,i-1,dp);
                     dp[i][j] = Math.max(pick,notpick);
            }
        }
        return dp[n-1][n];
    }
    // public int solve(int N,int[] price ,int index, int[][] dp){
    //     if(index == 0){
    //         dp[index][N] = N*price[index];
    //         return N*price[index];
    //     }
    //     int pick = 0;
    //     int curlen = index + 1;
    //     if ( curlen <= N){
    //         pick = price[index] + solve(N-curlen,price,index,dp);
    //     }
    //     int notpick = solve(N,price,index-1,dp);
    //      dp[index][N] = Math.max(pick,notpick);
        
    //     return dp[index][N];
    // }
}

// space optimization

class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        // int[][] dp = new int[n][n+1];
        int[] prev = new int[n+1];
        prev[0] = 0;
        for(int i = 0; i < n+1; i++){
            prev[i] = i*price[0];
        }
        for(int i = 1; i < n; i++){
            int[] cur = new int[n+1];
            for(int j = 0; j < n+1; j++){
                    int pick = 0;
                    int curlen = i + 1;
                    if ( curlen <= j){
                        pick = price[i] + cur[j-curlen]; // solve(j-curlen,price,i,dp);
                    }
                    int notpick = prev[j]; //solve(j,price,i-1,dp);
                     cur[j] = Math.max(pick,notpick);
            }
            prev = cur;
        }
        return prev[n];
    }
    // public int solve(int N,int[] price ,int index, int[][] dp){
    //     if(index == 0){
    //         dp[index][N] = N*price[index];
    //         return N*price[index];
    //     }
    //     int pick = 0;
    //     int curlen = index + 1;
    //     if ( curlen <= N){
    //         pick = price[index] + solve(N-curlen,price,index,dp);
    //     }
    //     int notpick = solve(N,price,index-1,dp);
    //      dp[index][N] = Math.max(pick,notpick);
        
    //     return dp[index][N];
    // }
}
