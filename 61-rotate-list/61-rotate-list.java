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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        if(count == 1){
            return head;
        }
        
        k = k % count;
        
        if(k==0){
            return head;
        }
        
        
        temp = head;
        int num = count - k;
        
        ListNode newHead;
        
        for(int i=0; i<num-1; i++){
            temp = temp.next;
        }
        newHead = temp.next;
        temp.next = null;
        
        temp = newHead;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        
        return newHead;
    }
}