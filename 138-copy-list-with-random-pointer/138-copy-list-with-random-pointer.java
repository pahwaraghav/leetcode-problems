/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node,Node> hmap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(hmap.containsKey(head)){
            return hmap.get(head);
        }
        Node n = new Node(head.val);
        hmap.put(head,n);
        n.next = copyRandomList(head.next);
        n.random = copyRandomList(head.random);
        return n;
    }
}