package BinaryTree_Traversal;

import Basic_Structue.TreeNode;

/**
 * Created by wlf on 9/8/14.
 */
public class Binary_Tree_Maximum_Path_Sum {
    public static void main(String[] args) {
        TreeNode root = Path_Sum.generateTree();
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
/*
        Given a binary tree, find the maximum path sum.

        The path may start and end at any node in the tree.

        For example:
        Given the below binary tree,

                1
                        / \
        2   3

        Return 6.
*/

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        rec(root, max);
        return max[0];
    }

    public static int rec(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int left = rec(node.left, max);
        int right = rec(node.right, max);

        int arch = left + node.val + right;
        int singleSide = Math.max(node.val, Math.max(node.val + left, node.val + right));
        int maxim = Math.max(arch, singleSide);
        max[0] = Math.max(max[0], maxim);
        return singleSide;
    }
}
