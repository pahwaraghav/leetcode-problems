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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1; i<preorder.length;i++){
            TreeNode currentNode = root;
            while(true){
                if(preorder[i] < currentNode.val){
                    if(currentNode.left == null){
                        currentNode.left = new TreeNode(preorder[i]);
                        break;
                    }
                    else{
                        currentNode = currentNode.left;
                    }
                }
                else{
                    if(currentNode.right == null){
                        currentNode.right = new TreeNode(preorder[i]);
                        break;
                    }
                    else{
                        currentNode = currentNode.right;
                    }
                }
            }
        }
        return root;
    }
}