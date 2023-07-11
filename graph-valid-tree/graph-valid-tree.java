class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
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
        visited.add(0);
        levels[0] = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i=0; i<size; i++) {
                int val = q.poll();
                List<Integer> nbrs = hmap.get(val);
                if(nbrs != null) {
                    for(int nbr: nbrs) {
                        if(visited.contains(nbr)) {
                            if(levels[nbr] != level-2) return false;
                        }
                        else{
                            visited.add(nbr);
                            levels[nbr] = level;
                            q.offer(nbr);
                        }
                    }
                }
            }
        }
        for(int val: levels) {
            if(val == -1) return false;
        }
        return true;
    }
}