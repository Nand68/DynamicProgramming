class Solution {
    public int change(int amount, int[] coins) {
         int n = coins.length;
        int[] prev = new int[amount+1];
        prev[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            if ((i % coins[0]) == 0) {
                prev[i] = 1;
            } else {
                prev[i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            int[] cur = new int[amount+1];
            for (int j = 0; j < amount + 1; j++) {
                int pick = 0;
                if (coins[i] <= j) {
                    pick = cur[j-coins[i]];
                }

                int notpick = prev[j]; 
                cur[j] = pick + notpick;
            }
            prev = cur;
        }
        int ans = prev[amount]; 
        return ans;
    }
}
