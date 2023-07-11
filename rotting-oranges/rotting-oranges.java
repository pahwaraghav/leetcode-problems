class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int orangesRotting(int[][] grid) {
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                    grid[i][j] = -1;
                    time = -1;
                }
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
            time++;
            for(int i=0; i<size; i++) {
                int[] coord = q.poll();
                for(int[] dir: dirs) {
                    int newI = coord[0] + dir[0];
                    int newJ = coord[1] + dir[1];
                    if(isValid(grid, newI, newJ)) {
                        q.offer(new int[]{newI, newJ});
                        grid[newI][newJ] = -1;
                    }
                }
            }
        }
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return time;
    }
    public boolean isValid(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != 1) return false;
        return true;
    }
}