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
public class Pair {
    TreeNode root;
    int num;

    Pair(TreeNode root, int num) {
        this.root = root;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        int first = 0, last = 0, res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int num = curr.num-1;

                if (i == 0) first = num;
                if (i == size-1) last = num;
                if (curr.root.left != null) {
                    q.offer(new Pair(curr.root.left, 2*num+1));
                }
                if (curr.root.right != null) {
                    q.offer(new Pair(curr.root.right, 2*num+2));
                }
            }
            res = Math.max(res, last-first+1);
        }
        return res;
    }
}