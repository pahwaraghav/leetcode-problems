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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        removeHelper(root,null,target);
        if(root.val == target && (root.left == null && root.right==null)) return null;
        return root;
    }
    public void removeHelper(TreeNode root, TreeNode parent, int target){
        if(root == null){
            return;
        }
        removeHelper(root.left,root,target);
        removeHelper(root.right,root,target);
        if(root.val == target && root.left == null && root.right == null){
            if(parent!=null){
                if(parent.left == root) parent.left = null;
                else parent.right = null;
            }
        }
    }
}