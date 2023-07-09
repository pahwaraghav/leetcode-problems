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
    public boolean isValidBST(TreeNode root) {
        return isValid(root.left,Long.MIN_VALUE, root.val * 1L, true) && isValid(root.right, root.val * 1L, Long.MAX_VALUE, false);
    }
    public boolean isValid(TreeNode root, Long min, Long max, boolean isLeft) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isValid(root.left, min, root.val * 1L, true) && isValid(root.right, root.val * 1L, max, false);
    }
}