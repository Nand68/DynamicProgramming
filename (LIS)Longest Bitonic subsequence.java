class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        if (n < 3) return 0; // A bitonic sequence needs at least 3 elements.

        int[] LIS = new int[n];
        int[] LDS = new int[n];

        // Initialize LIS and LDS with 1 (every element alone is a subsequence)
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            LDS[i] = 1;
        }

        // Compute LIS (Longest Increasing Subsequence)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        // Compute LDS (Longest Decreasing Subsequence)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && LDS[i] < LDS[j] + 1) {
                    LDS[i] = LDS[j] + 1;
                }
            }
        }

        int maxBitonicLength = 0;

        // Find the valid bitonic sequence length
        for (int i = 0; i < n; i++) {
            if (LIS[i] > 1 && LDS[i] > 1) { // A peak must have an increasing and decreasing part
                maxBitonicLength = Math.max(maxBitonicLength, LIS[i] + LDS[i] - 1);
            }
        }

        return maxBitonicLength; // Return 0 if no valid bitonic sequence exists
    }

}
