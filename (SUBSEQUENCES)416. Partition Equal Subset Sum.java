// simple recursion
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        if (total % 2 != 0)
            return false;
        int target = total / 2;
        return helepr(n - 1, target, nums);
    }

    public boolean helepr(int index, int target, int[] nums) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return nums[0] == target;
        }
        boolean nottake = helepr(index - 1, target, nums);
        boolean take = false;
        if (target >= nums[index]) {
            take = helepr(index - 1, target - nums[index], nums);
        }
        return take || nottake;
    }
}
// memorization
import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        if (total % 2 != 0)
            return false;
        int target = total / 2;
        Boolean[][] memo = new Boolean[n][target + 1];
        return helper(n - 1, target, nums, memo);
    }

    public boolean helper(int index, int target, int[] nums, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return nums[0] == target;
        }
        if (memo[index][target] != null) {
            return memo[index][target];
        }
        boolean notTake = helper(index - 1, target, nums, memo);
        boolean take = false;
        if (target >= nums[index]) {
            take = helper(index - 1, target - nums[index], nums, memo);
        }
        return memo[index][target] = take || notTake;
    }
}
// tabulation

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        if (total % 2 != 0)
            return false;
        int target = total / 2;
        boolean[][] memo = new boolean[n][target + 1];
        for(int i = 0; i < n; i++){
            memo[i][0] = true;
        }
        if (nums[0] <= target) {
            memo[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j < target+1; j++){
                boolean notTake = memo[i-1][j]; 
                boolean take = false;
                if (j >= nums[i]) {
                    take = memo[i-1][j-nums[i]]; 
                }    
                memo[i][j] = take || notTake;
            }
        }
        return memo[n-1][target];
    }
}

// space optimization

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        if (total % 2 != 0)
            return false;
        int target = total / 2;
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;
        if (nums[0] <= target) {
            prev[nums[0]] = true;
        }
        for (int i = 1; i < n; i++){
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int j = 1; j < target+1; j++){
                boolean notTake = prev[j]; 
                boolean take = false;
                if (j >= nums[i]) {
                    take = prev[j-nums[i]]; 
                }    
                curr[j] = take || notTake;
            }
            prev = curr;
        }
        return prev[target];
    }
}
