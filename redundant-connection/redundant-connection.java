class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] ids = new int[edges.length+1];
        int[] ans = new int[]{};
        for(int i=0; i<ids.length; i++) {
            ids[i] = i;
        }
        for(int[] edge: edges) {
            int p1 = find(ids, edge[0]);
            int p2 = find(ids, edge[1]);
            if(p1 == p2) {
                ans = new int[]{edge[0],edge[1]};
                continue;
            }
            else {
                union(ids, p1, p2);
            }
        }
        return ans;
    }
    public int find(int[] ids, int root) {
        while(ids[root] != root) {
            root = ids[root];
        }
        return root;
    }
    public void union(int[] ids, int root1, int root2) {
        ids[root1] = root2;
    }
}