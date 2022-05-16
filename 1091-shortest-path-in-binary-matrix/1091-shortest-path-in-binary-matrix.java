class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] != 0 || grid[m-1][n-1] != 0){
            return -1;
        }
        grid[0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size;i++){
                int[] cur = q.poll();
                if(cur[0] == m-1 && cur[1] == n-1){
                    return ans;
                }
                for(int j=-1; j<2;j++){
                    for(int k=-1;k<2;k++){
                        //if(j==0 && k==0) continue;
                        int newX = cur[0] + j;
                        int newY = cur[1] + k;
                        int[] arr = new int[]{newX,newY};
                        if(isValid(grid,newX,newY) && grid[newX][newY] == 0){
                            grid[newX][newY] = 1;
                            q.offer(arr);
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
    public boolean isValid(int[][] grid, int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return false;
        return true;
    }
}