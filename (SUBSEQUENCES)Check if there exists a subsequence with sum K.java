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

// bottom up 
class Solution {
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
      int[][] dp = new int[N][K+1];
      for(int i = 0; i < N; i++){
          dp[i][0] = 1;
      }
      for(int i = 1; i <= K; i++){
          if(i == arr[0]){
             dp[0][i] = 1;
          }
          else{
             dp[0][i] = 2;
          }
      }
      for(int i = 1;i < N; i++){
          for(int j = 1; j <= K; j++){
            int pick = 2;
                if ( arr[i] <= j){
                    pick = dp[i-1][j-arr[i]];//solve(arr,j-arr[i],i-1,dp);
                        if (pick == 1){
                            dp[i][j] = 1;
                            continue;
                        }
                        else{
                            dp[i][j] = 2;
                        }
                }
                int notpick = dp[i-1][j]; //solve(arr,j,i-1,dp);

                if (notpick == 1){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = 2;
                }
                
          }
      }
      return (dp[N-1][K] == 1);
  }
}

// space optimization
class Solution {
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    //   int[][] dp = new int[N][K+1];
    int[] prev = new int[K+1];
    //   for(int i = 0; i < N; i++){
    //       dp[i][0] = 1;
    //   }
    prev[0] = 1;
      for(int i = 1; i <= K; i++){
          if(i == arr[0]){
             prev[i] = 1;
          }
          else{
             prev[i] = 2;
          }
      }
      for(int i = 1;i < N; i++){
          int[] cur = new int[K+1];
          cur[0] = 1;
          for(int j = 1; j <= K; j++){
            int pick = 2;
                if ( arr[i] <= j){
                    pick = prev[j-arr[i]]; //solve(arr,j-arr[i],i-1,dp);
                        if (pick == 1){
                            cur[j] = 1;
                            continue;
                        }
                }
                int notpick = prev[j]; //solve(arr,j,i-1,dp);
                cur[j] = notpick;
                
          }
          prev = cur;
      }
      return (prev[K] == 1);
  }
}
     
     
  
     
