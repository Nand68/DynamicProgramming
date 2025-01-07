// without memo 
class Solution {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        return solve(arr, K, N - 1);
    }

    public static boolean solve(int[] arr, int target, int index) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return arr[index] == target;
        }
        boolean pick = false;
        if (arr[index] <= target) {
            pick = solve(arr, target - arr[index], index - 1);
        }
        boolean notpick = solve(arr, target, index - 1);
        return pick || notpick;
    }
}

// with memo 
class Solution {
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
      int[][] dp = new int[N][K+1];
      return solve(arr,K,N-1,dp);
  }
  public static boolean solve(int[] arr, int target, int index,int[][] dp ){
      if(target == 0){
          dp[index][target] = 1;
          return true;
      }
      
      if (index == 0) {
            if (arr[index] == target) {
                dp[index][target] = 1;
                return true;
            } else {
                dp[index][target] = 2;
                return false;
            }
      }
      
      if( dp[index][target] != 0){
         if ( dp[index][target] == 1){
             return true;
         }
         return false;
      }
      
      boolean pick = false;
      if ( arr[index] <= target){
          pick = solve(arr,target-arr[index],index-1,dp);
      }
      boolean notpick = solve(arr,target,index-1,dp);
      if ( pick == true){
          dp[index][target] = 1;
      }
      else{
          dp[index][target] = 2;
      }
      
      return pick || notpick;
  }
}
     
  
     
