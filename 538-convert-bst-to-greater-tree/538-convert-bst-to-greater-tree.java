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
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return root;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        getList(root,arr);
        Collections.sort(arr);
        ArrayList<Integer> preSum = new ArrayList<Integer>();
        preSum.add(arr.get(0));
        for(int i=1; i<arr.size();i++){
            preSum.add(preSum.get(i-1)+arr.get(i));
        }
        helper(root,arr,preSum);
        return root;
    }
    public void helper(TreeNode root, ArrayList<Integer> arr, ArrayList<Integer> preSum){
        if(root == null){
            return;
        }
        helper(root.left,arr,preSum);
        helper(root.right,arr,preSum);
        
        int idx = Collections.binarySearch(arr,root.val);
        int sum = preSum.get(preSum.size()-1) - preSum.get(idx);
        root.val = root.val + sum;
    }
    public void getList(TreeNode root,ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        getList(root.left,arr);
        getList(root.right,arr);
        arr.add(root.val);
    }
}