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
    boolean ans = true;
    public boolean isUnivalTree(TreeNode root) {
        helper(root,root.val);
        return ans;
    }
    public void helper(TreeNode root, int val){
        if(root == null) return;
        if(root.val != val) ans = false;
        helper(root.left,val);
        helper(root.right,val);
    }
}