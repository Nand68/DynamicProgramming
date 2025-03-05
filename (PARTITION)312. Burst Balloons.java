import java.util.*;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int num : nums) {
            list.add(num);
        }
        list.add(1);
        
        int[][] dp = new int[list.size()][list.size()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return helper(1, list.size() - 2, list, dp);
    }

    public int helper(int i, int j, List<Integer> list, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        
        int max = 0;
        for (int index = i; index <= j; index++) {
            int cost = (list.get(i - 1) * list.get(index) * list.get(j + 1))
                        + helper(i, index - 1, list, dp)
                        + helper(index + 1, j, list, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }
}
