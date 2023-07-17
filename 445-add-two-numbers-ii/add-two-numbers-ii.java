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
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ListNode temp = l1;
        while(temp != null) {
            st1.push(temp.val);
            temp = temp.next;
        }
        temp = l2;
        while(temp!= null) {
            st2.push(temp.val);
            temp = temp.next;
        }
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        int carry = 0;
        while(!st1.isEmpty() || !st2.isEmpty()) {
            int num1 = 0;
            int num2 = 0;
            if(!st1.isEmpty()) num1 = st1.pop();
            if(!st2.isEmpty()) num2 = st2.pop();
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
        }
        if(carry != 0) curr.next = new ListNode(carry);
        ans = ans.next;
        ListNode prev = null;
        while(ans != null) {
            ListNode next = ans.next;
            ans.next = prev;
            prev = ans;
            ans = next;
        }
        return prev;
    }
}