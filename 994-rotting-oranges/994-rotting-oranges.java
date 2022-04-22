class Pair{
    int x;
    int y;
    Pair(){}
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = 0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j));
                }
                if(grid[i][j] != 1) n++;
            }
        }
        if(q.isEmpty() && n == grid.length * grid[0].length){
            return 0;
        }
        int t = 0;
        while(!q.isEmpty()){
            int size = q.size();
            t++;
            for(int i=0; i<size;i++){
                Pair p = q.poll();
                if(isValid(grid,p.x-1,p.y) && grid[p.x-1][p.y] == 1){
                    System.out.println(p.x + " " + p.y);
                    grid[p.x-1][p.y] = 2;
                    n++;
                    q.offer(new Pair(p.x-1,p.y));
                }
                if(isValid(grid,p.x,p.y-1) && grid[p.x][p.y-1] == 1){
                    grid[p.x][p.y-1] = 2;
                    n++;
                    q.offer(new Pair(p.x,p.y-1));
                }
                if(isValid(grid,p.x+1,p.y) && grid[p.x+1][p.y] == 1){
                    grid[p.x+1][p.y] = 2;
                    n++;
                    q.offer(new Pair(p.x+1,p.y));
                }
                if(isValid(grid,p.x,p.y+1) && grid[p.x][p.y+1] == 1){
                    grid[p.x][p.y+1] = 2;
                    n++;
                    q.offer(new Pair(p.x,p.y+1));
                }
            }
        }
        if(n== grid.length * grid[0].length){
            return t-1;
        }
        return -1;
    }
    public boolean isValid(int[][] grid, int i, int j){
        if(i < 0 || i>=grid.length || j<0 || j>=grid[0].length) return false;
        return true;
    }
}