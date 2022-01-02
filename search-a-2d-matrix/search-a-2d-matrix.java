class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length -1;
        int mid = matrix.length / 2;
        int row = -1;
        if(target > matrix[right][0]){
            row = right;
        }
        else{
            while(left<=right){
                mid = (left + right ) /2;
                if(matrix[mid][0] == target){
                    return true;
                }
                if(matrix[mid][0] < target && matrix[mid+1][0] > target ){
                    row = mid;
                    break;
                }
                else if(matrix[mid][0] > target){
                    right = mid -1;
                }
                else if(matrix[mid][0] < target ){
                    left = mid +1;
                }
            }
        }
        if(row == -1){
            return false;
        }
        left = 0;
        right = matrix[0].length -1;
        mid = matrix[0].length /2;
        while(left <= right){
            mid = (left + right) /2;
            if(matrix[row][mid] == target){
                return true;
            }

            else if(matrix[row][mid] > target){
                right = mid -1;
            }
            else if(matrix[row][mid] < target){
                left = mid +1;
            }
        }
        return false;
    }
}