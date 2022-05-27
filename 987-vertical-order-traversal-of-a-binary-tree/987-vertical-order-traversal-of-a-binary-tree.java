/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Node{
    int x;
    int y;
    TreeNode node;
    Node(){}
    Node(TreeNode node, int x, int y){
        this.node = node;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer,List<Node>> hmap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        q.offer(new Node(root,0,0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size;i++){
                Node n = q.poll();
                min = Math.min(min,n.x);
                max = Math.max(max,n.x);
                List<Node> curList = hmap.getOrDefault(n.x,new ArrayList<Node>());
                curList.add(n);
                hmap.put(n.x,curList);
                if(n.node.left != null){
                    q.offer(new Node(n.node.left,n.x-1, n.y+1));
                }
                if(n.node.right != null){
                    q.offer(new Node(n.node.right, n.x+1,n.y+1));
                }
            }
        }
        for(int i=min; i<=max;i++){
            if(hmap.containsKey(i)){
                List<Node> cur = hmap.get(i);
                Collections.sort(cur, new Comparator<Node>(){
                    public int compare(Node n1, Node n2){
                        if(n1.y < n2.y) return -1;
                        else if(n1.y > n2.y) return 1;
                        return n1.node.val - n2.node.val;
                    }
                });
                List<Integer> lis = new ArrayList<>();
                for(Node n: cur){
                    lis.add(n.node.val);
                }
                res.add(lis);
            }
        }
        return res;
    }
}