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
        List<String> list = new ArrayList<>();
        helper(root, list);
        
        return String.join(",", list);
    }
    private void helper(TreeNode node, List<String> list){
        if(node == null){
            list.add("n");
            return;
        }
        list.add(String.valueOf(node.val));
        helper(node.left, list);
        helper(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val = data.split(",");
        index = 0;
        return helper2(val);
    }
    private int index;
    private TreeNode helper2(String[] val){
        
        if (val[index].equals("n")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val[index]));
        index++;
        node.left = helper2(val);
        node.right = helper2(val);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));