class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int res = 0;
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                if(dp[i][j] == -1){
                    getMax(matrix,dp,i,j,0);
                }
            }
        }
        return res;
    }
    public int getMax(int[][] matrix, int[][] dp, int i, int j, int curr){
        if(!validIndex(matrix,i,j)){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int max = 0;
        
        for(int[] dir: dirs){
            int newI = i + dir[0];
            int newJ = j+dir[1];
            if(validIndex(matrix,newI,newJ) && matrix[newI][newJ] > matrix[i][j]){
                max = Math.max(max,getMax(matrix,dp,newI,newJ,curr+1));
            }
        }
        dp[i][j] = 1 + max;
        res = Math.max(res,1+max);
        
        return 1 + max;
    }
    public boolean validIndex(int[][] matrix, int i, int j){
        if(i<0 || i>= matrix.length || j<0 || j>=matrix[0].length) return false;
        return true;
    }
}