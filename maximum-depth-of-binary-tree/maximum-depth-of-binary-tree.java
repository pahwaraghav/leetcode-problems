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
    public int maxDepth(TreeNode root) {
        return lengths(root,0,0);
    }
    public int lengths(TreeNode root, int currentLength, int maxLength){
        if(root == null) return Math.max(currentLength,maxLength);
        if(root.left == null && root.right == null){
            return Math.max(currentLength + 1,maxLength);
        }
        else{
            return Math.max(lengths(root.left,currentLength+1,maxLength),lengths(root.right,currentLength+1,maxLength));
        }
    }
}