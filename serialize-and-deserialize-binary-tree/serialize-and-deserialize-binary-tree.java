/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            arr.add(node != null ? node.val : null);
            if(node != null){
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        StringBuilder str = new StringBuilder();
		for (Integer val : arr) {
			str.append(val + "");
			str.append(",");
		}
        String s = str.toString();
        System.out.println(s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArr = data.split(",");
        String rootVal = strArr[0];
        if(rootVal.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        Queue<TreeNode> q = new LinkedList<>();
        int i=1;
        q.offer(root);
        while(!q.isEmpty()){
            if(i >= strArr.length) break;
            TreeNode curr = q.poll();
            String left = strArr[i++];
            String right = strArr[i++];
            if(!left.equals("null")) curr.left = new TreeNode(Integer.parseInt(left));
            if(!right.equals("null")) curr.right = new TreeNode(Integer.parseInt(right));
            if(curr.left != null) q.offer(curr.left);
            if(curr.right != null) q.offer(curr.right);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));