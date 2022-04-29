class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }
        if(board[x][y] == 'E'){
            reveal(board,x,y);
            return board;
        }
        else return board;
        
    }
    public void reveal(char[][] board, int i, int j){
        int val = getVal(board,i,j);
        if(val == 0) board[i][j] = 'B';
        else board[i][j] = (char)(val+'0');
        for(int x=i-1; x<=i+1;x++){
            for(int y=j-1; y<=j+1; y++){
                if(isValid(board,x,y) && board[x][y] =='E'){
                    if(val==0) reveal(board,x,y);
                }
            }
        }
    }
    public int getVal(char[][] board, int i, int j){
        int res = 0;
        for(int x=i-1; x<=i+1;x++){
            for(int y=j-1;y<=j+1;y++){
                if(isValid(board,x,y)){
                    if(board[x][y] == 'M') res++;
                }
            }
        }
        return res;
    }
    public boolean isValid(char[][] board, int i, int j){
        if(i <0 || i>= board.length || j<0 || j>= board[0].length) return false;
        return true;
    }
}