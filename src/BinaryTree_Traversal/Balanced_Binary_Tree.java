package BinaryTree_Traversal;

import Basic_Structue.TreeNode;

/**
 * Created by wlf on 9/8/14.
 */
public class Balanced_Binary_Tree {

    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (checkHeight(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = checkHeight(node.left);
        if (left == -1) {
            return -1;
        }
        int right = checkHeight(node.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;          // 别忘了加一
        }
    }
}
