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
        int res = 0;
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(points.length,new Node());
        pq.offer(new Node(0,0));
        while(!pq.isEmpty()){
            Node n = pq.poll();
            int num = n.num;
            if(visited.contains(num)) continue;
            for(int i=0; i<points.length;i++){
                if(i== num || visited.contains(i)) continue;
                int cost = Math.abs(points[num][0] - points[i][0]) + Math.abs(points[num][1] - points[i][1]);
                pq.offer(new Node(i,cost));
            }
            visited.add(num);
            res+= n.cost;
        }
        return res;
    }
}