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
    TreeNode head = new TreeNode();
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode temp = head;
        helper(root);
        root.left = null;
        root.right = temp.right.right;
    }
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode newNode = new TreeNode(root.val);
        head.right = newNode;
        TreeNode temp = head;
        head = head.right;
        helper(root.left);
        helper(root.right);
    }
}