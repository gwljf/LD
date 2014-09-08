package BinaryTree_Traversal;

import Basic_Structue.TreeNode;

/**
 * Created by wlf on 9/6/14.
 */
public class Valid_BST {
    public static void main (String[] args) {
        TreeNode root = generateBST();
        System.out.println(isValidBST(root));
        root = generateNonBST();
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        TreeNode node = root;
        return check(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean check (TreeNode node, int min, int max) {
        if (node == null) {
            return  true;
        } else if (node.val <= min || node.val >= max) {
            return false;
        } else {
            return check(node.left, min, node.val) && check(node.right, node.val, max);
        }
    }

    public static TreeNode generateBST () {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t0 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);


//                            6
//                  3                     9
//             2           5      7               10
//            1          4           8               11
        t6.left = t3; t6.right = t9;
        t3.left = t2; t3.right = t5;    t9.left = t7; t9.right = t0;
        t2.left = t1; t5.left = t4;     t7.right = t8; t0.right = t11;
        return  t6;
     }

    public static TreeNode generateNonBST () {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t0 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);


//                            6
//                  3                     9
//             2           5      7               10
//            1          4           8          11
        t6.left = t3; t6.right = t9;
        t3.left = t2; t3.right = t5;    t9.left = t7; t9.right = t0;
        t2.left = t1; t5.left = t4;     t7.right = t8; t0.left = t11;
        return  t6;
    }
}
