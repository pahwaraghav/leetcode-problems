class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int total = matrix.length * matrix[0].length;
        int curr = 0;
        List<Integer> ans = new ArrayList<>();
        while(curr<total){
            if(curr<total && top<=bottom){
                for(int i=left; i<=right; i++){
                    ans.add(matrix[top][i]); curr++;
                }
            }
            top++;
            if(curr<total && left<=right){
                for(int i=top; i<=bottom; i++){
                    ans.add(matrix[i][right]); curr++;
                }
            }
            right--;
            if(curr<total && bottom>=top){
                for(int i=right; i>=left; i--){
                    ans.add(matrix[bottom][i]); curr++;
                }
            }
            bottom--;
            if(curr<total && right>= left){
                for(int i=bottom; i>=top; i--){
                    ans.add(matrix[i][left]); curr++;
                }
            }
            left++;
        }
        return ans;
    }
}