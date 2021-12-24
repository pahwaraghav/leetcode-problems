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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[]{0};
        numOfChildren(root,max);
        return max[0] ;
    }
    public int numOfChildren(TreeNode root,int[] max){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left=0,right=0;
        if(root.left != null){
           left = numOfChildren(root.left,max);
        }
        if(root.right != null){
           right = numOfChildren(root.right,max);
        }
        max[0] = Math.max(max[0],left+right);
        return Math.max(left,right) + 1;
    }
}