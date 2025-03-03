class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int p = 1;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int lastIndex = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = dp[j]  +  1;
                    hash[i] = j;
                }
            }
            if ( p < dp[i]){
                p = dp[i];
                lastIndex = i;
            }
        }
        ans.add(nums[lastIndex]);
        while ( hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        // you can reverse string or return directly
        return ans;
    }
}
