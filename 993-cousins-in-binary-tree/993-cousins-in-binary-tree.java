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
    TreeNode p1;
    TreeNode p2;
    int d1;
    int d2;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,null,x,y,0);
        if(p1 == null || p2 == null) return false;
        if(p1 == p2 || d1 != d2) return false;
        return true;
        
    }
    public void helper(TreeNode root, TreeNode parent, int x, int y, int depth){
        if(root == null) return;
        if(root.val == x){
            p1 = parent;
            d1 = depth;
        }
        if(root.val == y){
            p2 = parent;
            d2 = depth;
        }
        helper(root.left,root,x,y,depth+1);
        helper(root.right,root,x,y,depth+1);
    }
}