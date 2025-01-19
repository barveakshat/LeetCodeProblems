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
    public int maxPathSum(TreeNode root) {
        //as we can't pass the reference of variable, that's why we are storing our maximum sum in an array
        int[] maxSum = new int[1];
        //Initialize maxsum with minimum value
        maxSum[0] = Integer.MIN_VALUE; 
        //now call our solve function, to find out the maximum sum
        solve(root,maxSum);
        return maxSum[0];
    }
    public int solve(TreeNode root, int[] maxSum){
        //if root is null, means there is no tree, so maxsum would be 0
        if(root==null) return 0;
        //find out the left sum
        int leftSum = solve(root.left, maxSum);
        //find out the right sum
        int rightSum = solve(root.right, maxSum);

        //Case 1: Jab leftside and rightside dono se achha sum aaya ho
        //But isme humara ulta U option ho jata hai, means hume niche hi answer mil gya 
        //so hum dusre path explore nhi krenge, aur iss value ko return nhi krenge
        int niche_Hi_Mil_Gya_Answer = root.val + leftSum + rightSum;
//Case 2: Jb dono main se koi ek hi achha ho, toh hum dono main se jo max hai usee aur node value ko hi lenge
        //aur yaha humare pass option hai explore krne ke liye toh hum isse return kr skte hai
        int koi_ek_achha_ho = root.val + Math.max(leftSum,rightSum); 
        //Case 3: Jb sirf node value hi achhi ho
        //aur yaha humare pass option hai explore krne ke liye toh hum isse return kr skte hai
        int onlyNode = root.val;
        //find the max sum
        //yaha hum 3 main se choose krenge konsa achha hai
        maxSum[0] = Math.max(maxSum[0], Math.max(niche_Hi_Mil_Gya_Answer, Math.max(koi_ek_achha_ho, onlyNode)));

        //Return krne ke liye humare pass 2 options hai case 2 aur 3 
        //aur hum dono main se Max return krenge
        return Math.max(koi_ek_achha_ho, onlyNode);
    }
}