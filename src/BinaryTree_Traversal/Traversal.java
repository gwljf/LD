package BinaryTree_Traversal;

import Basic_Structue.TreeNode;

import java.util.Stack;

/**
 * Created by wlf on 8/22/14.
 */
public class Traversal {
    public static void main (String[] args) {
        TreeNode root = generate();
        preOrderRec(root);
        System.out.println();
        preOrder(root);
        System.out.println();

        inOrderRec(root);
        System.out.println();
        inOrder(root);
        System.out.println();

        postOrderRec(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    public static void preOrderRec (TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        System.out.print(node.val + ",");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    public static void inOrderRec (TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode node = root;
        inOrderRec(root.left);
        System.out.print(node.val + ",");
        inOrderRec(root.right);
    }

    public static void postOrderRec (TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(node.val + ",");

    }

    public static void preOrder (TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.val + ",");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void inOrder (TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            node = stack.pop();
            System.out.print(node.val + ",");
            node = node.right;
        }
    }
    public static void postOrder (TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack1 = new Stack<Integer>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            stack1.push(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!stack1.isEmpty()) {
            System.out.print(stack1.pop() + ",");
        }
     }

    public static TreeNode generate () {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t4.right = t7;
        t5.left = t8;
        t5.right = t9;
        t7.left = t10;

        return t1;

//                                 1
//                  2                           3
//             4             5                        6
//                7      8       9
//              10
    }
}
