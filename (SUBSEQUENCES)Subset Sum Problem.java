// simple recursion
class Solution {
    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
        return helper(arr,target,n-1);
    }
    public static boolean helper(int arr[],int target, int index){
        if ( target == 0 ){
            return true;
        }
        if ( index == 0){
            return arr[0] == target;
        }
        boolean nottake = helper(arr,target,index-1);
        boolean take = false;
        if ( arr[index] <= target){
            take = helper(arr,target-arr[index],index-1);
        }
        
        return take || nottake;
    }
}
// with memo
class Solution {
    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][target + 1]; 
        return helper(arr, target, n - 1, dp);
    }

    public static boolean helper(int arr[], int target, int index, Boolean[][] dp) {
        if (target == 0) return true;  
        
        if (index == 0) return arr[0] == target; 

        if (dp[index][target] != null) return dp[index][target];

        boolean notTake = helper(arr, target, index - 1, dp);
        boolean take = false;

        if (arr[index] <= target) {
            take = helper(arr, target - arr[index], index - 1, dp);
        }

        return dp[index][target] = take || notTake;
    }
}
// tabulation
class Solution {
    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (arr[i] <= j) {
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        
        return dp[n - 1][target];
    }
}
// with space optimization
class Solution {
    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;

        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int j = 1; j <= target; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (arr[i] <= j) {
                    take = prev[j - arr[i]];
                }
                curr[j] = take || notTake;
            }
            prev = curr;
        }
        
        return prev[target];
    }
}
