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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0; i<inorder.length;i++){
            hmap.put(inorder[i],i);
        }
        return helper(preorder, inorder, hmap, 0, preorder.length-1, 0, inorder.length-1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, HashMap<Integer,Integer> hmap, int pStart, int pEnd, int iStart, int iEnd){
        if(pStart > pEnd || iStart > iEnd) return null;
        int val = preorder[pStart];
        TreeNode root = new TreeNode(val);
        
        int idx = hmap.get(val);
        
        root.left = helper(preorder,inorder, hmap, pStart+1, pStart + idx-iStart , iStart, idx-1);
        root.right = helper(preorder,inorder, hmap, pStart + idx - iStart + 1, pEnd , idx+1, iEnd);
        
        return root;
    }
}