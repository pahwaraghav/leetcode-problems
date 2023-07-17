class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> hmap = new HashMap<>();
        for(int j=0; j<grid.length; j++) {
            StringBuilder curr = new StringBuilder();
            for(int i=0; i<grid.length; i++) {
                curr.append(grid[i][j] +"-");
            }
            String hash = curr.toString();
            hmap.put(hash, hmap.getOrDefault(hash,0)+1);
        }
        int ans = 0;
        for(int i=0; i<grid.length; i++) {
            StringBuilder curr = new StringBuilder();
            for(int j=0; j<grid.length; j++) {
                curr.append(grid[i][j] +"-");
            }
            String str = curr.toString();
            if(hmap.containsKey(str)) {
                ans += hmap.get(str);
            }
        }
        return ans;
    }
}