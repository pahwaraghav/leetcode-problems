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
    public boolean isBalanced(TreeNode root) {
        int res = isBalancedHelper(root,0);
        System.out.println(res);
        if(res == Integer.MAX_VALUE) return false;
        return true;
    }
    
    public int isBalancedHelper (TreeNode root, int max){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        int left = isBalancedHelper(root.left,max);
        int right = isBalancedHelper(root.right,max);
        if(left==Integer.MAX_VALUE || right == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        int absChild = Math.abs(left - right);
        if(absChild > 1){
            return Integer.MAX_VALUE;
        } 
        return 1 + Math.max(left,right);
    }
}