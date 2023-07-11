class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        if(edges.length != n-1) return false;
        for(int[] edge: edges) {
            if(!hmap.containsKey(edge[0])) hmap.put(edge[0], new ArrayList<>());
            if(!hmap.containsKey(edge[1])) hmap.put(edge[1], new ArrayList<>());
            hmap.get(edge[0]).add(edge[1]);
            hmap.get(edge[1]).add(edge[0]);
        }
        int[] levels = new int[n];
        Arrays.fill(levels, -1);
        Queue<Integer> q =new LinkedList<>();
        int level = 0;
        q.add(0);
        levels[0] = 0;
        int j = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i=0; i<size; i++) {
                int val = q.poll();
                List<Integer> nbrs = hmap.get(val);
                if(nbrs != null) {
                    for(int nbr: nbrs) {
                        if(levels[nbr] != -1) {
                            if(levels[nbr] != level-2) return false;
                        }
                        else{
                            levels[nbr] = level;
                            q.offer(nbr);
                            j++;
                        }
                    }
                }
            }
        }
        return j == n;
    }
}