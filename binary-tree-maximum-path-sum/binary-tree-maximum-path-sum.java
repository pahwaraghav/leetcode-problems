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
    int ans = 0;
    public int maxPathSum(TreeNode root) {
        ans = root.val;
        helper(root);
        return ans;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int max = Math.max(root.val, Math.max(root.val + left, root.val + right));
        ans = Math.max(ans, Math.max(root.val + left + right, max));
        return max;
    }
}