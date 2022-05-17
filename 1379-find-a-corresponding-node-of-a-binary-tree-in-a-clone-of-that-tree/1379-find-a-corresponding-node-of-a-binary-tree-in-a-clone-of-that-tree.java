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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(original,target,arr);
        TreeNode ans = cloned;
        for(int num: path){
            if(num == 0){
                ans = ans.left;
            }
            else ans = ans.right;
        }
        return ans;
    }
    public void dfs(TreeNode root, TreeNode target, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        if(root == target){
            path = new ArrayList<>(arr);
            return;
        }
        arr.add(0);
        dfs(root.left,target,arr);
        arr.set(arr.size()-1,1);
        dfs(root.right,target,arr);
        arr.remove(arr.size()-1);
    }
}