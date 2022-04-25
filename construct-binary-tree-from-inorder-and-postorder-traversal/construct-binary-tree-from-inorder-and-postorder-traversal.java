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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0; i<inorder.length;i++){
            hmap.put(inorder[i],i);
        }
        return helper(inorder, postorder, hmap, 0, inorder.length-1, 0, postorder.length-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder, HashMap<Integer,Integer> hmap, int inStart, int inEnd, int pStart, int pEnd){
        if(inStart > inEnd || pStart > pEnd) return null;
        int val = postorder[pEnd];
        TreeNode root = new TreeNode(val);
        
        int numsLeft = hmap.get(val) - inStart;
        
        root.left = helper(inorder,postorder,hmap,inStart,hmap.get(val)-1, pStart, pStart + numsLeft -1);
        root.right = helper(inorder,postorder,hmap,hmap.get(val)+1,inEnd, pStart + numsLeft ,pEnd-1);
        
        return root;
    }
}