class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        LinkedList<Integer> li=new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                li.add(matrix[i][j]);
            }
        }
        if(li.contains(target)){
            return true;
        }
        else{
            return false;
        }
    }
}