class Solution {
    public int islandPerimeter(int[][] grid) {
        HashSet<String> visits = new HashSet<>();
        int a=-1,b=-1;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    a = i;
                    b = j;
                    break;
                }
            }
        }
        return dfs(a,b,visits,grid);
    }
    public int dfs(int i, int j, HashSet<String> visits, int[][] grid){
        if(i < 0 || j< 0 || i>= grid.length || j >= grid[0].length || grid[i][j]==0){
            return 1;
        }
        String tile = i + "-" + j;
        if(visits.contains(tile)){
            return 0;
        }
        
        visits.add(tile);
        int perimeter = 0;
        perimeter += dfs(i-1,j,visits,grid);
        perimeter += dfs(i+1,j,visits,grid);
        perimeter += dfs(i,j-1,visits,grid);
        perimeter += dfs(i,j+1,visits,grid);
        
        return perimeter;
    }
}