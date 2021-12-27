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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int i=0;
        while(temp!=null){
            temp = temp.next;
            i++;
        }
        if(i==1){
            return null;
        }
        if(n==i){
            head = head.next;
            return head;
        }
        int j = i - n;
        i = 1;
        temp = head;
        while(i<j){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
    }
}