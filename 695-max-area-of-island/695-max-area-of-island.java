class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    res = Math.max(res,bfs(grid,i,j));
                }
            }
        }
        return res;
    }
    
    public int bfs(int[][] grid, int i, int j){
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{1,0},{0,-1}, {0,1}};
        if(isValid(grid,i,j)){
            int[] or = {i,j};
            q.offer(or);
            ans++;
        }
        while(!q.isEmpty()){
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            for(int[] dir: dirs){
                int newX = x+dir[0];
                int newY = y+dir[1];
                if(isValid(grid,newX,newY) && grid[newX][newY] ==1){
                    q.offer(new int[]{newX,newY});
                    ans++;
                    grid[newX][newY] = 0;
                } 
            }
        }
        return ans;
    }
    
    public static boolean isValid(int[][] arr, int x, int y){
        if(x <0 || x >= arr.length || y <0 || y>=arr[0].length) return false;
        return true;
    }
}