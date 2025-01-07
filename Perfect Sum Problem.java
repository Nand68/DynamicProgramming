// with memo
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,target,n-1,dp);
    }
    public int solve(int[] arr, int target, int index,int[][] dp){
        if ( index == 0){
            if ( target == 0 && arr[0] == 0){
                dp[index][target] = 2;
                return 2;
            }
            else if ( target == 0){
                dp[index][target] = 1;
                return 1;
            }
            else if(arr[0] == target){
                dp[index][target] = 1;
                return 1;
            }
            else{
                dp[index][target] = 0;
                return 0;
            }
        }
        if ( dp[index][target] != -1){
            return dp[index][target];
        }
        int pick = 0;
        if(arr[index] <= target){
            pick = solve(arr,target-arr[index],index-1,dp);
        }
        
        int notpick = solve(arr,target,index-1,dp);
        dp[index][target] = pick + notpick;
        
        return pick + notpick;
    }
}
// bottom up 
class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for(int i = 0; i < target + 1; i++){
            if ( i == 0 && arr[0] == 0){
                dp[0][i] = 2;
            }
            else if ( i == 0){
                dp[0][i] = 1;
            }
            else if(arr[0] == i){
                dp[0][i] = 1;
            }
            else{
                dp[0][i] = 0;
            }
        }
        for ( int i = 1; i < n; i++){
            for ( int j = 0; j < target + 1; j++){
                    int pick = 0;
                    if(arr[i] <= j){
                        pick = dp[i-1][j-arr[i]]; //solve(arr,j-arr[i],i-1,dp);
                    }
                        
                    int notpick = dp[i-1][j]; //solve(arr,j,i-1,dp);
                    dp[i][j] = pick + notpick;
            }
        }
        
        return dp[n-1][target];
    }
}
