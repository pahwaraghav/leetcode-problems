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
    TreeNode start;
    TreeNode middle;
    TreeNode end;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        traverse(root);
        if(end == null){
            int temp = start.val;
            start.val = middle.val;
            middle.val = temp;
        }
        else{
            int temp = start.val;
            start.val = end.val;
            end.val = temp;
        }
    }
    public void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        if(prev != null && root.val < prev.val){
            if(start == null){
                start = prev;
                middle = root;
            }
            else{
                end = root;
            }
        }
        prev = root;
        traverse(root.right);
    }
}