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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next= reverseList(slow.next);
        
        ListNode one = head;
        ListNode two = slow.next;
        
        while(two != null){
            if(one.val == two.val){
                one = one.next;
                two = two.next;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public ListNode reverseList(ListNode head){
        ListNode previous = null;
        while(head != null){
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }
}