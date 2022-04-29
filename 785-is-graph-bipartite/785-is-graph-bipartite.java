class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors,-1);
        for(int i=0; i<colors.length;i++){
            if(colors[i] == -1){
                if(!dfs(graph,colors,i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph, int[] colors, int i){
        if(colors[i] == -1) colors[i] = 1;
        for(int j : graph[i]){
            if(colors[j] == -1){
                colors[j] = 1 - colors[i];
                if(!dfs(graph,colors,j)) return false;
            }
            else if(colors[j] == colors[i]){
                return false;
            }
        }
        return true;
    }
}
