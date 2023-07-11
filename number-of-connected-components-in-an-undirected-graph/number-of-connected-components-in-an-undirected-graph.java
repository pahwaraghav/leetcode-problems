class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        for(int[] edge: edges) {
            if(!hmap.containsKey(edge[0])) hmap.put(edge[0], new ArrayList<>());
            if(!hmap.containsKey(edge[1])) hmap.put(edge[1], new ArrayList<>());
            hmap.get(edge[0]).add(edge[1]);
            hmap.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                count++;
                dfs(hmap, visited, i);
            }
        }
        return count;
    }
    public void dfs(HashMap<Integer,List<Integer>> hmap, HashSet<Integer> visited, int val) {
        visited.add(val);
        List<Integer> lis = hmap.get(val);
        if(lis == null) return;
        for(int num: lis) {
            if(!visited.contains(num)) {
                visited.add(num);
                dfs(hmap, visited, num);
            }
        }
    }
}