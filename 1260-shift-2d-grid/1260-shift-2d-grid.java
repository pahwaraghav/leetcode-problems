class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m*n);
        
        int row, col;
        row = m - (k-1) / n - 1;
        col = n - (k-1) % n - 1;
        System.out.println(row + " " + col);
        int num = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=row; i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i== row && j<col){
                    continue;
                }
                if(num == grid[0].length){
                    res.add(arr);
                    arr = new ArrayList<Integer>();
                    num = 0;
                }
                arr.add(grid[i][j]);
                num++;
            }
        }
        for(int i=0; i<=row;i++){
            for(int j=0; j<grid[0].length;j++){
                if(i == row && j == col){
                    break;
                }
                if(num == grid[0].length){
                    res.add(arr);
                    arr = new ArrayList<Integer>();
                    num = 0;
                }
                arr.add(grid[i][j]);
                num++;
            }
        }
        res.add(arr);
        return res;
    }
}