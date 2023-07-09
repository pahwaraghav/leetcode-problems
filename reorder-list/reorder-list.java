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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode otherHead = reverse(slow);
        ListNode temp = head;
        ListNode temp2 = otherHead;
        while(temp!= null && temp2.next != null) {
            ListNode next1 = temp.next;
            ListNode next2 = temp2.next;
            temp.next = temp2;
            temp2.next = next1;
            temp = next1;
            temp2 = next2;
        }
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head!= null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}