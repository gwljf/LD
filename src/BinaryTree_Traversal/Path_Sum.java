package BinaryTree_Traversal;

import Basic_Structue.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlf on 9/7/14.
 */
public class Path_Sum {
    public static void main(String[] args) {
        TreeNode root = generateTree();

        System.out.println(hasPathSum(root, 22));

        List<List<Integer>> ret = pathSum(root, 22);
        for (List<Integer> x : ret) {
            System.out.println(x);
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            return rec(root, sum, 0);
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> al = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        } else {
            rec(ret, al, root, sum, 0);
            return ret;
        }
    }

    public static boolean rec(TreeNode node, int sum, int tmpVal) {
        tmpVal += node.val;
        if (node.left == null && node.right == null) {
            if (tmpVal == sum) {
                return true;
            } else {
                return false;
            }
        } else if (node.left == null) {
            return rec(node.right, sum, tmpVal);
        } else if (node.right == null) {
            return rec(node.left, sum, tmpVal);
        } else {
            return rec(node.right, sum, tmpVal) || rec(node.left, sum, tmpVal);
        }
    }

    public static void rec(List<List<Integer>> ret, List<Integer> al, TreeNode node, int sum, int tmpVal) {
        tmpVal += node.val;
        al.add(node.val);
        if (node.left == null && node.right == null) {
            if (tmpVal == sum) {
                ret.add(new ArrayList<Integer>(al));
            }
        } else if (node.left == null) {
            rec(ret, al, node.right, sum, tmpVal);
        } else if (node.right == null) {
            rec(ret, al, node.left, sum, tmpVal);
        } else {
            rec(ret, al, node.left, sum, tmpVal);
            rec(ret, al, node.right, sum, tmpVal);
        }
        tmpVal -= node.val;
        al.remove(al.size() - 1);
    }

    public static TreeNode generateTree() {
//                 5
//                / \
//               4   8
//              /   / \
//             11  13  4
//            /  \      \
//           7    2      1
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t8 = new TreeNode(8);
        TreeNode t11 = new TreeNode(11);
        TreeNode t13 = new TreeNode(13);
        TreeNode t41 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);

        t5.left = t4;
        t5.right = t8;
        t4.left = t11;
        t8.left = t13;
        t8.right = t41;
        t11.left = t7;
        t11.right = t2;
        t41.right = t1;

        return t5;

    }
}
