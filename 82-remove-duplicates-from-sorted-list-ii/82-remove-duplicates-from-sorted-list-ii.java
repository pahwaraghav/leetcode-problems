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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode headTemp = newHead;
        ListNode temp = head;
        
        while(temp != null){
            int count = 1;
           
            while(temp.next != null && temp.val == temp.next.val){
                count++;
                temp = temp.next;
            }
            
            if(count == 1){
                ListNode newNode = new ListNode(temp.val);
                headTemp.next = newNode;
                headTemp = headTemp.next;
            }
             temp = temp.next;
        }
        return newHead.next;
    }
}