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
        int n = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        ListNode temp = head;
        int i = 0;
        while(temp != null){
            hmap.put(i++, temp.val);
            temp = temp.next;
            n++;
        }
        int max = 0;
        for(i=0; i<=n/2; i++){
            int curr = hmap.get(i) + hmap.get(n-i-1);
            max = Math.max(max, curr);
        }
        return max;
    }
}