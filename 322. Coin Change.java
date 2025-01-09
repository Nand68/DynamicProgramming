// simple recursion without memo
class Solution {
    int mod = (int)1e9;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = solve(coins,amount,n-1);
        if(ans == mod){
            return -1;
        }
        return ans;
    }
    public int solve(int[] coins, int amount, int index){
        if(index == 0){
            if ( (amount % coins[0]) == 0){
                return amount / coins[index];
            }
            else{
                return mod;
            }
        }
        int pick = mod;
        if ( coins[index] <= amount){
            pick = 1 + solve(coins,amount-coins[index],index);
        }

        int notpick = solve(coins,amount,index-1);

        return Math.min(pick,notpick);
    }
}

// with memorization

class Solution {
    int mod = (int)1e9;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        int ans = solve(coins,amount,n-1,dp);
        if(ans == mod){
            return -1;
        }
        return ans;
    }
    public int solve(int[] coins, int amount, int index, int[][] dp){
        if(index == 0){
            if ( (amount % coins[0]) == 0){
                dp[index][amount] = amount / coins[index];
                return amount / coins[index];
            }
            else{
                dp[index][amount] = mod;
                return mod;
            }
        }
        if(dp[index][amount] != 0){
            return dp[index][amount];
        }
        int pick = mod;
        if ( coins[index] <= amount){
            pick = 1 + solve(coins,amount-coins[index],index,dp);
        }

        int notpick = solve(coins,amount,index-1,dp);

        dp[index][amount] = Math.min(pick,notpick);
        return dp[index][amount];
    }
}

// tabulization 

class Solution {
    int mod = (int) 1e9;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int i = 0; i < amount + 1; i++) {
            if ((i % coins[0]) == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = mod;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < amount + 1; j++) {
                int pick = mod;
                if (coins[i] <= j) {
                    pick = 1 + dp[i][j-coins[i]]; //solve(coins, j - coins[i], i, dp);
                }

                int notpick = dp[i-1][j]; //solve(coins, j, i - 1, dp);

                dp[i][j] = Math.min(pick, notpick);
            }
        }
        int ans = dp[n-1][amount]; //solve(coins, amount, n - 1, dp);
        if (ans == mod) {
            return -1;
        }
        return ans;
    }

    // public int solve(int[] coins, int amount, int index, int[][] dp) {
    //     if (index == 0) {
    //         if ((amount % coins[0]) == 0) {
    //             dp[index][amount] = amount / coins[index];
    //             return amount / coins[index];
    //         } else {
    //             dp[index][amount] = mod;
    //             return mod;
    //         }
    //     }
    //     if (dp[index][amount] != 0) {
    //         return dp[index][amount];
    //     }
    //     int pick = mod;
    //     if (coins[index] <= amount) {
    //         pick = 1 + solve(coins, amount - coins[index], index, dp);
    //     }

    //     int notpick = solve(coins, amount, index - 1, dp);

    //     dp[index][amount] = Math.min(pick, notpick);
    //     return dp[index][amount];
    // }
}

// with space optimzation 

class Solution {
    int mod = (int) 1e9;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // int[][] dp = new int[n][amount+1];
        int[] prev = new int[amount+1];
        prev[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            if ((i % coins[0]) == 0) {
                prev[i] = i / coins[0];
            } else {
                prev[i] = mod;
            }
        }
        for (int i = 1; i < n; i++) {
            int[] cur = new int[amount+1];
            for (int j = 0; j < amount + 1; j++) {
                int pick = mod;
                if (coins[i] <= j) {
                    pick = 1 + cur[j-coins[i]]; //solve(coins, j - coins[i], i, dp);
                }

                int notpick = prev[j]; //solve(coins, j, i - 1, dp);

                cur[j] = Math.min(pick, notpick);
            }
            prev = cur;
        }
        int ans = prev[amount]; //solve(coins, amount, n - 1, dp);
        if (ans == mod) {
            return -1;
        }
        return ans;
    }

    // public int solve(int[] coins, int amount, int index, int[][] dp) {
    //     if (index == 0) {
    //         if ((amount % coins[0]) == 0) {
    //             dp[index][amount] = amount / coins[index];
    //             return amount / coins[index];
    //         } else {
    //             dp[index][amount] = mod;
    //             return mod;
    //         }
    //     }
    //     if (dp[index][amount] != 0) {
    //         return dp[index][amount];
    //     }
    //     int pick = mod;
    //     if (coins[index] <= amount) {
    //         pick = 1 + solve(coins, amount - coins[index], index, dp);
    //     }

    //     int notpick = solve(coins, amount, index - 1, dp);

    //     dp[index][amount] = Math.min(pick, notpick);
    //     return dp[index][amount];
    // }
}
