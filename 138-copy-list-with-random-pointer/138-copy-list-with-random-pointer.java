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
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        
        HashMap<Node,Node> hmap = new HashMap<Node,Node>();
        
        Node temp = head;
        Node newHead = null;
        Node newTemp = null;
        
        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.random = temp.random;
            if(newTemp ==null){
                newHead = newNode;
                newTemp = newNode;
            }
            else{
                newTemp.next = newNode;
            }
            newTemp = newNode;
            hmap.put(temp,newNode);
            temp = temp.next;
        }
        newTemp = newHead;
        while(newTemp != null){
            if(newTemp.random != null){
                Node nd = hmap.get(newTemp.random);
                newTemp.random = nd;
            }
            newTemp =newTemp.next;
        }
        return newHead;
    }
}