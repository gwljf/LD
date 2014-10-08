package BinaryTree_Traversal;

import Basic_Structue.TreeNode;

/**
 * Created by wlf on 9/6/14.
 */
public class Flatten_Binary_Tree_to_Linked_List {
    public static void main (String[] args) {
        TreeNode root = generteTree();
        flatten(root);

        TreeNode tmp = root;
        while (tmp != null) {
            System.out.print(tmp.val+"->");
            tmp = tmp.right;
        }
    }
/*
    Given a binary tree, flatten it to a linked list in-place.

            For example,
            Given

               1
              / \
             2   5
            / \   \
           3   4   6

    The flattened tree should look like:

            1
             \
              2
               \
                3
                 \
                  4
                   \
                    5
                     \
                      6
*/

    public static void flatten(TreeNode root) {
        if (root != null) {
            rec(root);
        }
    }

    public static TreeNode rec (TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        } else if (node.left == null) {
            node.right = rec(node.right);
            return node;
        } else if (node.right == null) {
            node.right = rec(node.left);
            node.left = null;
            return node;
        } else {
            TreeNode tmp = node.right;
            node.right = rec(node.left);
            node.left = null;
            TreeNode find = node;
            while (find.right != null) {
                find = find.right;
            }
            find.right = rec(tmp);
            return node;
        }
    }

    public static TreeNode generteTree () {
//                 1
//                / \
//               2   5
//              / \   \
//             3   4   6
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2; t1.right = t5;
        t2.left = t3; t2.right = t4;
        t5.right = t6;

        return t1;
    }
}
