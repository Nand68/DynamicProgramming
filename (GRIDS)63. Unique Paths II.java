class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n =obstacleGrid[0].length;
        int[] prev = new int[n+1];
        for(int i = 1; i < m+1; i++){
            int[] cur = new int[n+1];
            for(int j = 1; j < n+1; j++){
                if(i == 0 || j == 0 || obstacleGrid[i-1][j-1] == 1){
                    cur[j] = 0;
                }
                else if ( i == 1 && j == 1){
                    cur[j] = 1;
                }
                else{
                    cur[j] = cur[j-1] + prev[j]; 
                }
            }
            prev = cur;
        }
        return prev[n];
    }
}
