class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length+1];
        for(int[] arr: dp) {
            Arrays.fill(arr,  Integer.MAX_VALUE);
        }
        return helper(grid, 0, grid[0].length, dp);
    }
    public int helper(int[][] grid, int i, int prev, int[][] dp) {
        if(!isValid(grid, i)) {
            return 0;
        }
        if(dp[i][prev] != Integer.MAX_VALUE) {
            return dp[i][prev];
        }
        int min = Integer.MAX_VALUE;
        for(int j=0; j<grid[0].length; j++) {
            if(j==prev) {
                continue;
            }
            int sum = grid[i][j] + helper(grid, i+1, j, dp);
            min = Math.min(min, sum);
        }
        return dp[i][prev] = min;
    }
    public boolean isValid(int[][] grid, int i) {
        if(i<0 || i>=grid.length) return false;
        return true;
    }
}