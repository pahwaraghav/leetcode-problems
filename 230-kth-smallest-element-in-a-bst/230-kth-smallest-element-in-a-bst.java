/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        int count = 0;
        TreeNode temp = root;
        while(!st.isEmpty() || temp!= null){
            if(temp!=null){
                st.push(temp);
                temp = temp.left;
            }
            else{
                TreeNode node = st.pop();
                count++;
                if(count == k) return node.val;
                temp = node.right;
            }
        }
        return -1;
    }
}