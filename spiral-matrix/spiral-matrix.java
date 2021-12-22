class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        int totalSize = matrix.length * matrix[0].length;
        int count = 0;
        
        List<Integer> res = new ArrayList<>();
        
        while(top<=bottom && left<=right){
            for(int i=left; i<=right;i++){
                if(count>=totalSize){
                    break;
                }
                res.add(matrix[top][i]);
                count++;
                
            }
            top++;
            
            for(int i=top;i<=bottom;i++){
                if(count>=totalSize){
                    break;
                }
                res.add(matrix[i][right]);
                count++;
            }
            right--;
            
            for(int i=right;i>=left;i--){
                if(count>=totalSize){
                    break;
                }
                res.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            
            for(int i=bottom;i>=top;i--){
                if(count>=totalSize){
                    break;
                }
                res.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        
        return res;
    }
}