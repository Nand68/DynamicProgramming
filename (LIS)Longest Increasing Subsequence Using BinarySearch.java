import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        
        for (int num : nums) {
            int idx = Collections.binarySearch(dp, num);
            
            if (idx < 0) {
                idx = -(idx + 1); // Convert negative index to insertion point
            }
            
            if (idx == dp.size()) {
                dp.add(num); // Extend the subsequence
            } else {
                dp.set(idx, num); // Replace element at index
            }
        }
        
        return dp.size();
    }
}
