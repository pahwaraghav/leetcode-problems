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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> pathSums = pathSum(root,0,new ArrayList<Integer>());
        
        for(int i=0; i<pathSums.size();i++){
            if(targetSum == pathSums.get(i)) return true;
        }
        return false;
    }
    public ArrayList<Integer> pathSum(TreeNode root, int currentSum, ArrayList<Integer> ans){
        if(root == null) return ans;
        if(root.left == null && root.right==null){
            ans.add(currentSum + root.val);
        }
        else{
            pathSum(root.left, currentSum + root.val, ans);
            pathSum(root.right, currentSum + root.val, ans);
        }
        
        return ans;
    }
}