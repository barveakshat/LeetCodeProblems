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
class Tuple {
    TreeNode node;
    int col, row;

    public Tuple(TreeNode node, int col, int row) {
        this.node = node;
        this.col = col;
        this.row = row;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map to hold column index to a TreeMap of row index to a list of node values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> columnMap = new TreeMap<>();

        // Perform BFS
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0)); // Start with root node at column 0, row 0

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            TreeNode node = current.node;
            int col = current.col;
            int row = current.row;

            // Add node value to the columnMap
            columnMap.putIfAbsent(col, new TreeMap<>());
            columnMap.get(col).putIfAbsent(row, new PriorityQueue<>());
            columnMap.get(col).get(row).offer(node.val);

            // Add children to the queue
            if (node.left != null) {
                queue.offer(new Tuple(node.left, col - 1, row + 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, col + 1, row + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : columnMap.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : rows.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }
            result.add(column);
        }

        
        return result;
    }
}