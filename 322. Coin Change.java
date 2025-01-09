// simple recursion without memo
class Solution {
    int mod = (int)1e9;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = solve(coins,amount,n-1);
        if(ans == mod){
            return -1;
        }
        return ans;
    }
    public int solve(int[] coins, int amount, int index){
        if(index == 0){
            if ( (amount % coins[0]) == 0){
                return amount / coins[index];
            }
            else{
                return mod;
            }
        }
        int pick = mod;
        if ( coins[index] <= amount){
            pick = 1 + solve(coins,amount-coins[index],index);
        }

        int notpick = solve(coins,amount,index-1);

        return Math.min(pick,notpick);
    }
}
