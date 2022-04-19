/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode lNode = new ListNode();
        ListNode temp = lNode;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i=0; i<lists.length;i++){
            if(lists[i] != null){
               q.offer(lists[i]); 
            }
        }
        while(!q.isEmpty()){
            ListNode prevNode = q.poll();
            ListNode node = new ListNode(prevNode.val);
            temp.next = node;
            temp = temp.next;
            if(prevNode.next != null){
                q.offer(prevNode.next);
            }
        }
        return lNode.next;
    }
}