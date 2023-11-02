// https://leetcode.com/problems/path-sum

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        if(root == null) return false;

        boolean targetReached = false;

        if(root.left != null) 
            targetReached = targetReached || hasPathSum(root.left, targetSum, sum+root.val);

        if(targetReached == true) 
            return true;
        
        if(root.right != null) 
            targetReached = targetReached || hasPathSum(root.right, targetSum, sum+root.val);

        if(targetReached == true) 
            return true;

        if(root.left == null && root.right == null) {
            if (targetSum == sum+root.val) {
                return true;
            } else {
                return false;
            }
        }

        return targetReached;
        
    }
}
