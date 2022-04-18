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

class TreeInfo{
    int numVisited;
    int lastVisited;
    TreeInfo(){}
    TreeInfo(int numVisited,int lastVisited){
        this.numVisited = numVisited;
        this.lastVisited = lastVisited;
    }
}
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeInfo info = new TreeInfo(0,-1);
        traverse(root,k,info);
        return info.lastVisited;
    }
    public void traverse(TreeNode root, int k, TreeInfo info){
        if(root == null || k < info.numVisited){
            return;
        }
        traverse(root.left,k,info);
        info.numVisited++;
        if(info.numVisited == k){
            info.lastVisited = root.val;
        }
        traverse(root.right,k,info);
    }
}