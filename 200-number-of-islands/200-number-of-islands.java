class Pair{
    int i;
    int j;
    Pair(){}
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int ans = 0;
        for(int i=0; i<rows;i++){
            for(int j=0; j<cols;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    ans++;
                    bfs(grid,i,j,visited);
                }
            }
        }
        return ans;
    }
    public void bfs(char[][] grid,int i, int j, boolean[][] visited){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i,j));
        visited[i][j] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
            for(int[] dir : dirs){
                int r = dir[0] + p.i;
                int c = dir[1] + p.j;
                if(isValid(grid,r,c) && !visited[r][c] && grid[r][c] =='1'){
                    q.offer(new Pair(r,c));
                    visited[r][c] = true;
                }
            }
        }
    }
    public boolean isValid(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return false;
        return true;
    }
}