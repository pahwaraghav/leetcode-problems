class Node implements Comparator<Node>{
    int num;
    int cost;
    Node(){}
    Node(int num, int cost){
        this.num = num;
        this.cost = cost;
    }
    public int compare(Node n1,Node n2){
        return n1.cost - n2.cost;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<Node>> li = new ArrayList<>();
        for(int i=0; i<points.length;i++) li.add(new ArrayList<>());
        for(int i=0; i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i==j) continue;
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                li.get(i).add(new Node(j,cost));
            }
        }
        
        int res = 0;
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(points.length,new Node());
        pq.offer(new Node(0,0));
        while(!pq.isEmpty()){
            Node n = pq.poll();
            int num = n.num;
            if(visited.contains(num)) continue;
            List<Node> ar = li.get(num);
            for(Node node : ar){
                pq.add(node);
            }
            visited.add(num);
            res+= n.cost;
        }
        return res;
    }
}