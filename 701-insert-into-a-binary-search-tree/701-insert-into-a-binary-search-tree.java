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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode parent = root;
        TreeNode child = parent.val > val ? root.left : root.right;
        
        while(child != null){
            parent = child;
            child = child.val > val ? child.left : child.right;
        }
        TreeNode node = new TreeNode(val);
        if(parent.left == null && parent.val > val){
            parent.left = node;
        }
        else{
            parent.right = node;
        }
        return root;
    }
}