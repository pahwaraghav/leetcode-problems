/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1 = getLength(headA);
        int n2 = getLength(headB);
        
        
        while(n1 > n2){
            headA = headA.next;
            n1--;
        }
        
        while(n2 > n1){
            headB = headB.next;
            n2--;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public int getLength(ListNode head){
        int i = 0;
        while(head != null){
            head = head.next;
            i++;
        }
        return i;
    }
}