/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        head = newNode;
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                break;
            }
        }
        if(slow == null) return null;
        fast = head;
        while(slow != fast){
            if(slow == null) return null;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}