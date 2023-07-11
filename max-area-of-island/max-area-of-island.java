class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = -1;
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    public int bfs(int[][] grid, int i, int j) {
        int count = 0;
        grid[i][j] = -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()) {
            int[] coord = q.poll();
            count++;
            for(int[] dir: dirs) {
                int newI = coord[0] + dir[0];
                int newJ = coord[1] + dir[1];
                if(isValid(grid, newI, newJ)) {
                    q.offer(new int[]{newI, newJ});
                    grid[newI][newJ] = -1;
                }
            }
        }
        return count;
    }
    public boolean isValid(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || grid[i][j] != 1) return false;
        return true;
    }
}