/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        buildParentsMap(root, null, parents);
        q.add(target);
        visited.add(target);
        int i=0;
        while(!q.isEmpty() || i<k) {
            int size = q.size();
            for(int j=0; j<size; j++) {
                TreeNode node = q.poll();
                if(i==k) ans.add(node.val);
                if(node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.offer(node.left);
                }
                if(node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.offer(node.right);
                }
                if(parents.get(node)!=null && !visited.contains(parents.get(node))) {
                    visited.add(parents.get(node));
                    q.offer(parents.get(node));
                }
            }
            i++;
        }
        return ans;
    }
    public void buildParentsMap(TreeNode root, TreeNode parent, HashMap<TreeNode,TreeNode> hmap) {
        if(root == null) return;
        hmap.put(root,parent);
        buildParentsMap(root.left, root, hmap);
        buildParentsMap(root.right, root, hmap);
    }
}