class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int Max = 1;
        int lastIndex = 0;
        int[] dp = new int[n];
        int[] hash = new int[n];
        
        // Initialize dp and hash
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            hash[i] = i;
        }

        // Fill dp and hash for LIS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > Max) {
                Max = dp[i];
                lastIndex = i;
            }
        }

        // Backtrack to reconstruct the LIS
        while (hash[lastIndex] != lastIndex) {
            ans.add(arr[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        ans.add(arr[lastIndex]);

        // Reverse the result list to get the correct order of LIS
        Collections.reverse(ans);
        return ans;
    }
}
