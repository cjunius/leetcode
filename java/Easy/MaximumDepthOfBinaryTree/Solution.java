// https://leetcode.com/problems/maximum-depth-of-binary-tree

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
    public int maxDepth(TreeNode root) {
        return maxDepthRecursive(root);
        //return maxDepthIterativeBFS(root);
        //return maxDepthIterativeDFS(root);        
    }

    // 0ms 100%, 41.39MB 58.03%
    public int maxDepthRecursive(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return ( left > right ) ? left + 1 : right + 1;
    }

    // 1ms 10.90%, 43.24MB 5.85%
    public int maxDepthIterativeBFS(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while(!queue.isEmpty()) {
            depth++;

            int size = queue.size();
            while(size > 0) {
                TreeNode node = queue.poll();
                size--;

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }

    // 2ms 10.90%, 41.22MB 70.80%
    public int maxDepthIterativeDFS(TreeNode root) {
        if(root == null) return 0;

        int max = 0;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        nodes.push(root);
        depth.push(1);

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int cur = depth.pop();

            if(node.left == null && node.right == null) {
                max = (max > cur) ? max : cur;
            } else {
                cur++;
                if (node.left != null) {
                    nodes.push(node.left);
                    depth.push(cur);
                }
                if (node.right != null) {
                    nodes.push(node.right);
                    depth.push(cur);
                }
            }
        }
        return max;
    }

}
