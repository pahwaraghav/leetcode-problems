class Node implements Comparator<Node>{
    int v;
    int w;
    Node(){};
    Node(int v, int w){
        this.v = v;
        this.w = w;
    }
    public int compare(Node n1, Node n2){
        return n1.w - n2.w;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for(int[] curr : times){
            int u = curr[0];
            int v = curr[1];
            int w = curr[2];
            Node node = new Node(v-1,w);
            arr.get(u-1).add(node);
        }
        
        int[] res = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[k-1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(n,new Node());
        pq.offer(new Node(k-1,0));
        while(!pq.isEmpty()){
            Node newNode = pq.poll();
            int u = newNode.v;
            for(Node curr: arr.get(u)){
                if(res[u] + curr.w < res[curr.v]){
                    res[curr.v] = res[u] + curr.w;
                    pq.offer(curr);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int num: res){
            ans = Math.max(ans,num);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}