class Solution {
    public void gameOfLife(int[][] board) {
        
        int[][] ans = solve(board);
        for(int i=0; i<ans.length;i++){
            for(int j=0; j<ans[0].length;j++){
                board[i][j] = ans[i][j];
            }
        }
    }
    public static int[][] solve(int[][] board){
        int[][] res = new int[board.length][board[0].length];
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                int num = board[i][j];
                int neighbors = countNeighbors(board,i,j);
                //System.out.println(i + " " + j + " " + neighbors);
                if(num == 0){
                    if(neighbors == 3){
                        res[i][j] =1;
                    }
                }
                else{
                    if(neighbors <2){
                        res[i][j] = 0;
                    }
                    else if(neighbors ==2 || neighbors ==3){
                        res[i][j] =1;
                    }
                    else{
                        res[i][j]= 0;
                    }
                }
            }
        }
        return res;
    }
    public static int count(int[][] arr, int i, int j){
        if(i <0 || i>=arr.length || j<0 || j>=arr[0].length){
            return 0;
        }
        return arr[i][j];
    }
    public static int countNeighbors(int[][]arr, int i, int j){
        int res = 0;
        res += count(arr,i-1,j-1);
        res += count(arr,i-1,j);
        res += count(arr,i-1,j+1);
        res += count(arr,i,j-1);
        res += count(arr,i,j+1);
        res += count(arr,i+1,j-1);
        res += count(arr,i+1,j);
        res += count(arr,i+1,j+1);
        return res;
    }
}