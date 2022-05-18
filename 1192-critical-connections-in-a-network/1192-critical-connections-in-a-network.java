class Solution {
    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n];
        int[] low = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.fill(disc,-1);
        
        for(int i=0; i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<connections.size();i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i=0; i<n;i++){
            if(disc[i] == -1){
                dfs(i,low,disc,graph,ans,i);
            }
        }
        return ans;
    }
    public void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre){
        disc[u] = time++;
        low[u] = time;
        for(int j=0; j<graph[u].size();j++){
            int v = graph[u].get(j);
            if(v == pre){
                continue;
            }
            if (disc[v] == -1) {
			    dfs(v, low, disc, graph, res, u);
			    low[u] = Math.min(low[u], low[v]);
			    if (low[v] > disc[u]) {
				    res.add(Arrays.asList(u, v));
			    }
		    } 
            else {
			    low[u] = Math.min(low[u], disc[v]);
		    }
        }
    }
}