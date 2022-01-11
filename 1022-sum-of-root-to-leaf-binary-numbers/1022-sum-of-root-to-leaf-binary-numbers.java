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
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = new int[1];
        getPaths(root,"",sum);
        return sum[0];
    }
    public void getPaths(TreeNode root, String current, int[] sum){
        if(root== null) return;
        if(root.left == null && root.right == null){
            sum[0] += binaryStringToInt(current + root.val);
        }
        getPaths(root.left, current+root.val,sum);
        getPaths(root.right, current+root.val, sum);
    }
    public int binaryStringToInt(String s){
        int res = 0;
        int len = s.length();
        for(int i=0; i<s.length();i++){
            if(s.charAt(len-i-1) == '1') res += Math.pow(2,i);
        }
        return res;
    }
}