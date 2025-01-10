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
