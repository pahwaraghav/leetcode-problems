class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<graph.length; i++) adjList.add(new ArrayList<>());
        int[] outDegree = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            int vertex = i;
            for(int node: graph[i]) {
                adjList.get(node).add(vertex);
            }
            outDegree[i] = graph[i].length;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        addZeroDegrees(outDegree, q);
        while(!q.isEmpty()) {
            int val = q.poll();
            ans.add(val);
            List<Integer> lis = adjList.get(val);
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