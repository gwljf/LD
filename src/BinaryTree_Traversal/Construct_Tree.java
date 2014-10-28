package BinaryTree_Traversal;

import Basic_Structue.TreeNode;

/**
 * Created by wlf on 9/7/14.
 */
public class Construct_Tree {

    public static void main(String[] args) {
        int[] preorder = {5, 4, 11, 7, 2, 8, 13, 4, 1};
        int[] inorder = {7, 11, 2, 4, 5, 13, 8, 4, 1};
        int[] postorder = {7, 2, 11, 4, 13, 1, 4, 8, 5};

        TreeNode root1 = buildTreeFromInPost(inorder, postorder);
        Traversal.inOrderRec(root1);
        System.out.println();
        Traversal.postOrderRec(root1);

        System.out.println();
        TreeNode root2 = buildTreeFromPreIn(preorder, inorder);
        Traversal.preOrderRec(root2);
        System.out.println();
        Traversal.inOrderRec(root2);
    }

    public static TreeNode buildTreeFromInPost(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        if (inorder.length == 0) {
            return null;
        }
        TreeNode root = InPost(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }

    public static TreeNode InPost(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postEnd]);
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                rootIndex = i;
                break;
            }
        }
        node.left = InPost(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + rootIndex - inStart - 1);
        node.right = InPost(inorder, rootIndex + 1, inEnd, postorder, postStart + rootIndex - inStart, postEnd - 1);
        return node;
    }

    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = PreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    public static TreeNode PreIn(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == preorder[preStart]) {
                rootIndex = i;
                break;
            }
        }
        node.left = PreIn(preorder, preStart + 1, preStart + rootIndex - inStart, inorder, inStart, rootIndex - 1);
        node.right = PreIn(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return node;
    }

//                 5
//                / \
//               4   8
//              /   / \
//             11  13  4
//            /  \      \
//           7    2      1

}
