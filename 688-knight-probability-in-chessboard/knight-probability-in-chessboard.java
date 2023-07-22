class Solution {
    int[][] dirs = {{-1,2}, {1,2}, {-2,1}, {2,1}, {-2,-1}, {2, -1}, {-1,-2}, {1,-2}};
    public double knightProbability(int n, int k, int row, int column) {
        if(k==0) return 1.0;
        double[][][] memo = new double[n][n][k+1];
        for(double[][] rows: memo) {
            for(double[] nesRow: rows) Arrays.fill(nesRow, -1.0);
        }
        double count = outCount(n, k, row, column, memo);
        double res = count / Math.pow(8.0, k);
        return res;
    }
    public double outCount(int n, int k, int row, int col, double[][][] dp) {
        if(k==0) return 1;
        double count = 0;
        if(dp[row][col][k] != -1.0) return dp[row][col][k];
        for(int[] dir: dirs) {
            int newX = row + dir[0];
            int newY = col + dir[1];
            if(isValid(n, newX, newY)) {
                count += outCount(n, k-1, newX, newY, dp);
            }
        }
        return dp[row][col][k] = count;
    }
    public boolean isValid(int n, int row, int col) {
        if(row < 0 || col <0 || row>=n || col >=n) return false;
        return true;
    }
}