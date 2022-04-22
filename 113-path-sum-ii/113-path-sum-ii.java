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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root,ans,new ArrayList<>(),0,targetSum);
        return ans;
    }
    public void helper(TreeNode root,List<List<Integer>> ans, List<Integer> curList, int sum, int targetSum){
        if(root == null) return;
        curList.add(root.val);
        helper(root.left,ans,curList,sum+root.val,targetSum);
        helper(root.right,ans,curList,sum+root.val,targetSum);
        if(root.left == null && root.right == null && sum + root.val == targetSum){
            List<Integer> li = new ArrayList<>(curList);
            ans.add(li);
        }
        curList.remove(curList.size()-1);
    }
}