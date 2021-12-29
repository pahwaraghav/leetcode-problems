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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while(list1 != null || list2 != null){
            ListNode val;
            if(list1 == null) val = list2;
            else if (list2 == null) val = list1;
            else{
                if(list1.val < list2.val) val = list1;
                else val = list2;
            }
            temp.next = val;
            temp = temp.next;
            if(val == list1) list1 = list1.next;
            else list2 = list2.next;
        }
        return head.next;
    }
}