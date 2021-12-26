/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 m
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaHelper(root,p,q);
    }
    
    public TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        
        if(root.val == p.val || root.val==q.val){
            return root;
        }
        
        TreeNode left = lcaHelper(root.left,p,q);
        TreeNode right = lcaHelper(root.right,p,q);
        
        if(left != null && right != null) return root;
        
        if(left == null && right != null) return right;
        return left;
    }
}