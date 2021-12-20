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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return calculateMinDepth(root,0,Integer.MAX_VALUE);
    }
    
    public int calculateMinDepth(TreeNode root, int currentDepth, int mindep){
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null){
            return Math.min(currentDepth + 1,mindep);
        }
        else{
            return Math.min(calculateMinDepth(root.left,currentDepth + 1, mindep), calculateMinDepth(root.right,currentDepth + 1, mindep));
        }
    }
}