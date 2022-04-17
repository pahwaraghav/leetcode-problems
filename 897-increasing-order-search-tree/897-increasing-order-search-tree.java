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
    TreeNode curr = new TreeNode();
    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = curr;
        helper(root);
        return node.right;
    }
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        curr.right = new TreeNode(root.val);
        curr = curr.right;
        helper(root.right);
    }
}