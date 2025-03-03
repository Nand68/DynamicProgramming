class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n];
        int ans = 1;
        for(int i = 0; i < n; i++){
            prev[i] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    prev[i] = Math.max(prev[i],1+prev[j]);
                }
            }
            ans = Math.max(ans,prev[i]);
        }
        return ans;
    }
}


// memo

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1]; // dp[index][prev_index+1] for handling -1 case
        for (int[] row : dp) Arrays.fill(row, -1);
        return lisHelper(nums, 0, -1, dp);
    }

    private int lisHelper(int[] nums, int index, int prevIndex, int[][] dp) {
        if (index == nums.length) return 0;
        
        if (dp[index][prevIndex + 1] != -1) return dp[index][prevIndex + 1];

        // Option 1: Skip the current element
        int length = lisHelper(nums, index + 1, prevIndex, dp);

        // Option 2: Include the current element if it's greater than the previous one
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            length = Math.max(length, 1 + lisHelper(nums, index + 1, index, dp));
        }

        return dp[index][prevIndex + 1] = length;
    }
}
