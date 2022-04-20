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
class BSTIterator {
    
    TreeNode root;
    Stack<Integer> st;

    public BSTIterator(TreeNode root) {
        this.root = root;
        st = new Stack<>();
        inOrder(root,st);
    }
    
    private void inOrder(TreeNode root, Stack<Integer> li){
        if(root == null){
            return;
        }
        inOrder(root.right,li);
        st.push(root.val);
        inOrder(root.left,li);
    }
    
    public int next() {
        return st.pop();
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */