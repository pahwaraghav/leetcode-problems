class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '2';
        for(int[] dir: dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(isValid(grid, newI, newJ)) {
                dfs(grid, newI, newJ);
            }
        }
    }
    public boolean isValid(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || grid[i][j] != '1') return false;
        return true;
    }
}