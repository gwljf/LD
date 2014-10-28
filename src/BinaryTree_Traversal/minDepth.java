package BinaryTree_Traversal;

import Basic_Structue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wlf on 9/8/14.
 */
public class minDepth {
    public static void main(String[] args) {
        TreeNode root = Path_Sum.generateTree();
        System.out.println(minDepth(root));
        System.out.println(minDepthRec(root));
    }

    public static int minDepth(TreeNode root) {    // 广度优先遍历; 如果要求最大, 则一直走下去就好了,然后返回height
        if (root == null) {
            return 0;
        }
        TreeNode node = root;
        int height = 1;
        int curLen = 1;
        int nextLen = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            for (int i = 1; i <= curLen; i++) {
                node = queue.poll();
                if (node.left == null && node.right == null) {
                    return height;
                } else if (node.left == null) {
                    queue.offer(node.right);
                    nextLen++;
                } else if (node.right == null) {
                    queue.offer(node.left);
                    nextLen++;
                } else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    nextLen += 2;
                }
            }
            height++;
            curLen = nextLen;
            nextLen = 0;
        }
        return height;
    }

    public static int minDepthRec(TreeNode root) {
        return shortest(root);
    }

    public static int shortest(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right == null) {
            return shortest(root.left) + 1;
        } else if (root.left == null && root.right != null) {
            return shortest(root.right) + 1;
        } else {
            return Math.min(shortest(root.left), shortest(root.right)) + 1;
        }
    }
}
