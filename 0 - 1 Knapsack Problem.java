// memorization
class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        return solve(capacity, val, wt , n-1,dp);

    }
    public static int solve(int capacity, int[] val, int[] wt, int index, int[][] dp){
        if( capacity == 0){
            dp[index][capacity] = 0;
            return 0;
        }
        if ( index == 0){
            if (wt[index] <= capacity){
                dp[index][capacity] = val[index];
                return val[index];
            }
            else{
                dp[index][capacity] = 0;
                return 0;
            }
        }
        int pick = 0;
        if( wt[index] <= capacity){
            pick = val[index] + solve(capacity-wt[index], val, wt, index - 1,dp);
        }
        
        int notpick = solve(capacity, val, wt, index - 1,dp);
        
        dp[index][capacity] = Math.max(pick, notpick);
        return dp[index][capacity];
    }
}



// tabulation 
class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i < capacity+1; i++){
            if (wt[0] <= i){
                dp[0][i] = val[0];
            }
            else{
                dp[0][i] = 0;
            }
        }
        for(int i = 1; i < n; i++){
            for ( int j = 1; j < capacity+1; j++){
                    int pick = 0;
                    if( wt[i] <= j){
                        pick = val[i] + dp[i-1][j-wt[i]]; //solve(j-wt[i], val, wt, i - 1,dp);
                    }
                    
                    int notpick = dp[i-1][j]; //solve(j, val, wt, i - 1,dp);
                    
                    dp[i][j] = Math.max(pick, notpick);
                
            }
        }
        // return solve(capacity, val, wt , n-1,dp);
        return dp[n-1][capacity];
    }
}


// with space optimization 

class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        int n = val.length;
        // int[][] dp = new int[n][capacity+1];
        int[] prev = new int[capacity+1];
        prev[0] = 0;
     
        // for(int i = 0; i < n; i++){
        //     dp[i][0] = 0;
        // }
        for(int i = 0; i < capacity+1; i++){
            if (wt[0] <= i){
                prev[i] = val[0];
            }
            else{
                prev[i] = 0;
            }
        }
        for(int i = 1; i < n; i++){
            int[] cur = new int[capacity+1];
            for ( int j = 1; j < capacity+1; j++){
                    int pick = 0;
                    if( wt[i] <= j){
                        pick = val[i] + prev[j-wt[i]]; 
                    }
                    
                    int notpick = prev[j]; 
                    
                    cur[j] = Math.max(pick, notpick);
                
            }
            prev = cur;
        }
        return prev[capacity];
    }
}

