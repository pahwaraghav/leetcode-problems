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
        if(root.left==null && root.right==null) return true;
        return validateBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean validateBST(TreeNode node, long minValue, long maxValue){
        if(node == null) return true;
        if(node.val <= minValue || node.val >= maxValue){
            return false;
        }
        else{
            return validateBST(node.left,minValue,node.val) && validateBST(node.right,node.val, maxValue);
        }
    }
}