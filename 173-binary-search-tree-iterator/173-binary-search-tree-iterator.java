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
    ArrayList<Integer> li;
    int currIdx;

    public BSTIterator(TreeNode root) {
        this.root = root;
        li = new ArrayList<>();
        inOrder(root,li);
        currIdx = -1;
    }
    
    private void inOrder(TreeNode root, ArrayList<Integer> li){
        if(root == null){
            return;
        }
        inOrder(root.left,li);
        li.add(root.val);
        inOrder(root.right,li);
    }
    
    public int next() {
        currIdx++;
        return li.get(currIdx);
    }
    
    public boolean hasNext() {
        if(currIdx < li.size()-1){
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */