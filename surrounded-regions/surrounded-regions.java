class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][n-1] == 'O') dfs(board, i, n-1);
        }
        for(int j=0; j<n; j++) {
            if(board[0][j] == 'O') dfs(board, 0, j);
            if(board[m-1][j] == 'O') dfs(board, m-1, j);
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'F') board[i][j] = 'O';
            }
        }
    }
    public void dfs(char[][] board, int i, int j) {
        if(board[i][j] != 'O') return;
        board[i][j] = 'F';
        for(int[] dir: dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(isValid(board, newI, newJ)) {
                dfs(board, newI, newJ);
            }
        }
    }
    public boolean isValid(char[][] board, int i, int j) {
        if(i<0 || j<0 || i>=board.length || j>= board[0].length || board[i][j] != 'O') return false;
        return true;
    }
}