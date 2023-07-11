class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[rooms.length][rooms[0].length];
        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    visited[i][j] = 1;
                    q.offer(new int[]{i,j});
                }
            }
        }
        bfs(rooms,q, visited);
    }
    public void bfs(int[][] rooms, Queue<int[]> q, int[][] visited) {
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int k=0; k<size; k++) {
                int[] coord = q.poll();
                for(int[] dir: dirs) {
                    int newI = coord[0] + dir[0];
                    int newJ = coord[1] + dir[1];
                    if(isValid(rooms,newI,newJ,visited)) {
                        q.offer(new int[]{newI, newJ});
                        rooms[newI][newJ] = Math.min(rooms[newI][newJ], level);
                        visited[newI][newJ] = 1;
                    }
                }
            }
        }
    }
    public boolean isValid(int[][] rooms, int i, int j, int[][] visited) {
        if(i<0 || j<0 || i>= rooms.length | j>= rooms[0].length || rooms[i][j] == -1 || visited[i][j] == 1) return false;
        return true;
    }
}