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
        ListNode greater = n1 > n2 ? headA : headB;
        ListNode smaller = headA == greater ? headB : headA;
        
        ListNode temp = greater;
        ListNode temp2 = smaller;
        HashSet<ListNode> hset = new HashSet<>();
        while(temp2 != null){
            hset.add(temp2);
            temp2 = temp2.next;
        }
        while(temp != null){
            if(hset.contains(temp)) return temp;
            temp = temp.next;
        }
        return null;
    }
    public int getLength(ListNode head){
        int i = 0;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            i++;
        }
        return i * 2;
    }
}