class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        int[] outDegree = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            int vertex = i;
            for(int node: graph[i]) {
                if(!hmap.containsKey(node)) hmap.put(node, new ArrayList<>());
                hmap.get(node).add(vertex);
            }
            outDegree[i] = graph[i].length;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        addZeroDegrees(outDegree, q);
        while(!q.isEmpty()) {
            int val = q.poll();
            ans.add(val);
            List<Integer> lis = hmap.get(val);
            if(lis == null) continue;
            for(int node: lis) {
                outDegree[node]--;
            }
            addZeroDegrees(outDegree, q);
        }
        Collections.sort(ans);
        return ans;
    }
    public void addZeroDegrees(int[] degrees, Queue<Integer> q) {
        for(int i=0; i<degrees.length; i++) {
            if(degrees[i] == 0) {
                q.offer(i);
                degrees[i]--;
            }
        }
    }
}