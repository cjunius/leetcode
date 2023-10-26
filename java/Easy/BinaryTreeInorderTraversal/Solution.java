// https://leetcode.com/problems/binary-tree-inorder-traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversalRecursive(root);
        //return inorderTraversalStackIteration(root);
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> nodes = inorderTraversal(root.left);
        nodes.add(root.val);

        if(root.right != null) {
            nodes.addAll(inorderTraversal(root.right));
        }

        return nodes;
        
    }

    public List<Integer> inorderTraversalStackIteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur!= null || !stack.empty()) {
            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
