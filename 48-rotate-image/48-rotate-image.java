class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<matrix.length;i++){
            reverse(matrix[i]);
        }
    }
    public void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            arr[start] = arr[start] ^ arr[end];
            arr[end] = arr[start] ^ arr[end];
            arr[start] = arr[start] ^ arr[end];
            start++;end--;
        }
    }
}