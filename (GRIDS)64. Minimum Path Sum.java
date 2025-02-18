class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n]; 

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n]; 
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else {
                    int up = grid[i][j] + (i > 0 ? prev[j] : (int)1e9);
                    int left = grid[i][j] + (j > 0 ? curr[j - 1] : (int)1e9);
                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr; 
        }
        return prev[n - 1];
    }
}
