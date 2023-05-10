class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int[][] ans = new int[n][n];
        int i=1;
        while(i<=n*n && left<=right && top<=bottom){
            for(int j=left; j<=right; j++){
                ans[top][j] = i++;
            }
            top++;
            for(int j=top; j<=bottom; j++){
                ans[j][right] = i++;
            }
            right--;
            for(int j=right; j>=left; j--){
                ans[bottom][j] = i++;
            }
            bottom--;
            for(int j=bottom; j>=top; j--){
                ans[j][left] = i++;
            }
            left++;
        }
        return ans;
    }
}