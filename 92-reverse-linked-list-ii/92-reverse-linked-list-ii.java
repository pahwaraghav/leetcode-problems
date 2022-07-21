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
    public ListNode reverseBetween(ListNode head, int left, int right) {
                if(head.next==null) return head;
                int count=1;
                ListNode prev = null;
                ListNode curr = head;

                while(count < left){
                    prev = curr;
                    curr = curr.next;
                    count++;
                }

                ListNode start = prev;
                ListNode end = curr;

                while(count <= right){
                    ListNode temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                    count++;
                }

                if(start != null)
                    start.next = prev;
                else
                    head = prev;

                end.next=curr;

                return head;
    }
}