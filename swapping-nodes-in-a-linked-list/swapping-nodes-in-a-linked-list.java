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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, slow = head, first = head, second = head;
        for(int i=1; i<k;i++){
            fast = fast.next;
        }
        first = fast;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        second = slow;
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}