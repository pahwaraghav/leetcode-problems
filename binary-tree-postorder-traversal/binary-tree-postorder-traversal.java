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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lis = new ArrayList<>();
        if(root == null) return lis;
        HashSet<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.peek();
            if(curr.left == null || visited.contains(curr.left)){
                if(curr.right == null || visited.contains(curr.right)){
                    st.pop();
                    lis.add(curr.val);
                    visited.add(curr);
                }
                else{
                    if(curr.right!=null) st.push(curr.right);
                }
            }
            else{
                if(curr.left !=null) st.push(curr.left);
            }
        }
        return lis;
    }
}