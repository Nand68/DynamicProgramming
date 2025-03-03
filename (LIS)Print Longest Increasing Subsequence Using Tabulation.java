import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int ans = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
