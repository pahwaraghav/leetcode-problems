/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return ans;
    }
    public boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        
        boolean left = helper(root.left,p,q);
        boolean right = helper(root.right,p,q);
        
        if(left && right){
            ans = root;
        }
        boolean rootEqual = root.val == p.val || root.val == q.val;
        if(rootEqual){
            if(left || right){
                ans = root;
            }
        }
        return left || right || rootEqual;
    }
}