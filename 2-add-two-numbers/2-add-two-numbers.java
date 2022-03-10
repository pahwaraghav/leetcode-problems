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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        
        int carry = 0;
        while(l1!= null || l2 != null){
            int n1 = 0, n2=0;
            if(l1 != null){
                n1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                n2 = l2.val;
                l2 = l2.next;
            }
            int sum = (n1 + n2 + carry);
            if(sum >= 10) sum -=10;
            carry = (n1 + n2 + carry) / 10;
            
            
            ListNode newNode = new ListNode(sum);
            temp.next = newNode;
            temp = newNode;
        }
        
        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
            temp = newNode;
        }
        
        return head.next;
    }
}