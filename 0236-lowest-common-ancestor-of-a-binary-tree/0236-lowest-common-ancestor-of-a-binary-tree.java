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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Base Case:
        //1. If root is null return null
        //2. If root is equal to p or q, return that root
        if(root == null || root == p || root == q) return root;
        //Traverse Left side
        TreeNode leftN = lowestCommonAncestor(root.left, p, q);
        //Traverse Right side
        TreeNode rightN = lowestCommonAncestor(root.right, p, q);
        //Case 1: If both leftN and rightN are not null, means we got our p and q, so return the root where we got both p and q
        if(leftN != null && rightN != null) return root;
        //Case 2: If LeftN is null and rightN is not null, then return rightN
        //If rightN is null and leftN is not null, then return leftN
        return leftN == null ? rightN : leftN;
    }
}