class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> hmap = new HashMap<>();
        for(int j=0; j<grid.length; j++) {
            int[] curr = new int[grid.length];
            for(int i=0; i<grid.length; i++) {
                curr[i] = grid[i][j];
            }
            String hash = Arrays.toString(curr);
            hmap.put(hash, hmap.getOrDefault(hash,0)+1);
        }
        int ans = 0;
        for(int i=0; i<grid.length; i++) {
            String str = Arrays.toString(grid[i]);
            if(hmap.containsKey(str)) {
                ans += hmap.get(str);
            }
        }
        return ans;
    }
}