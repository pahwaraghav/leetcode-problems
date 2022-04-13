class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int k = 1;
        int dir = 0;
        while(true){
            if(k>n*n){
                break;
            }
            if(dir == 0){
                for(int i=left; i<=right;i++){
                    arr[top][i] = k++;
                }
                top++;
            }
            else if(dir ==1){
                for(int i=top; i<=bottom;i++){
                    arr[i][right] = k++;
                }
                right--;
            }
            else if(dir == 2){
                for(int i=right; i>=left;i--){
                    arr[bottom][i] = k++;
                }
                bottom--;
            }
            else{
                for(int i=bottom; i>=top;i--){
                    arr[i][left] = k++;
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return arr;
    }
}