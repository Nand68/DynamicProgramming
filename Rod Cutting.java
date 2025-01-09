class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        return solve(n,price,n-1);
    }
    public int solve(int N,int[] price ,int index){
        if(index == 0){
            return N*price[index];
        }
        int pick = 0;
        int curlen = index + 1;
        if ( curlen <= N){
            pick = price[index] + solve(N-curlen,price,index);
        }
        int notpick = solve(N,price,index-1);
        
        return Math.max(pick,notpick);
    }
}
