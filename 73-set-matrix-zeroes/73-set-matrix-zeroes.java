class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowContainsZero = false;
        boolean colContainsZero = false;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int i=0; i<rows;i++){
            if(matrix[i][0] == 0){
                rowContainsZero = true;
                break;
            }
        }
        for(int i=0; i<cols;i++){
            if(matrix[0][i] == 0){
                colContainsZero = true;
                break;
            }
        }
        
        for(int i=1;i<rows;i++){
            for(int j=1; j<cols;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<rows;i++){
            for(int j=1; j<cols;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowContainsZero){
            for(int i=0;i<rows;i++){
                matrix[i][0] = 0;
            }
        }
        if(colContainsZero){
            for(int i=0; i<cols;i++){
                matrix[0][i] = 0;
            }
        }
    }
}