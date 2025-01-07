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
