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
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        
        ListNode temp = head;
        ListNode tempHead1 = head1;
        ListNode tempHead2 = head2;
        
        while(temp != null){
            if(temp.val < x){
                tempHead1.next = new ListNode(temp.val);
                tempHead1 = tempHead1.next;
            }
            else{
                tempHead2.next = new ListNode(temp.val);
                tempHead2 = tempHead2.next;
            }
            temp = temp.next;
        }
        tempHead1.next = head2.next;
        return head1.next;
    }
}