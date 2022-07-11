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
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        helper(root,hmap,0);
        List<Integer> li = new ArrayList<>();
        int i=0;
        while(hmap.containsKey(i)){
            li.add(hmap.get(i++));
        }
        return li;
    }
    public void helper(TreeNode root, HashMap<Integer,Integer> hmap, int level){
        if(root == null){
            return;
        }
        helper(root.right,hmap,level+1);
        
        if(!hmap.containsKey(level)){
            hmap.put(level,root.val);
        }
        
        helper(root.left,hmap,level+1);
        
    }
}