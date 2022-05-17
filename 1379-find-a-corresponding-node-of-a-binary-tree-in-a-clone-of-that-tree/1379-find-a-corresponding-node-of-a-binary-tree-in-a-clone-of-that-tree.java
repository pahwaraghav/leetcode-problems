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
    ArrayList<Integer> path;
    TreeNode ans;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(original,target,cloned);
        return ans;
    }
    public void dfs(TreeNode root, TreeNode target, TreeNode cloned){
        if(root == null){
            return;
        }
        if(root == target){
            ans = cloned;
            return;
        }
        dfs(root.left,target,cloned.left);
        dfs(root.right,target,cloned.right);
    }
}