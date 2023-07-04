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
    int sum = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }
    public Result helper(TreeNode root) {
        if(root == null) return new Result(0,0);
        Result left = helper(root.left);
        Result right = helper(root.right);
        sum += Math.abs(left.sum - right.sum);
        return new Result(Math.abs(left.sum - right.sum), root.val + left.sum + right.sum);
    }
}

class Result {
    int tilt;
    int sum;

    Result() {}
    Result(int tilt, int sum) {
        this.tilt = tilt;
        this.sum = sum;
    }
}