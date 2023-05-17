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
    public int pairSum(ListNode head) {
        List<Integer> lis = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            lis.add(temp.val);
            temp = temp.next;
        }
        int max = 0;
        int n = lis.size();
        for(int i=0; i<=n/2; i++){
            int curr = lis.get(i) + lis.get(n-i-1);
            max = Math.max(max, curr);
        }
        return max;
    }
}