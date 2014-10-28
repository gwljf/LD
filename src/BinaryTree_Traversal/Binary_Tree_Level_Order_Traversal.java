package BinaryTree_Traversal;

import Basic_Structue.TreeNode;

import java.util.*;

/**
 * Created by wlf on 9/17/14.
 */
public class Binary_Tree_Level_Order_Traversal {
/*

    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree {3,9,20,#,#,15,7},

            3
            / \
            9  20
            /  \
            15   7

            return its bottom-up level order traversal as:

            [
            [15,7],
            [9,20],
            [3]
            ]
*/


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> done = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        queue.offer(root);
        int curLen = 1;
        int nextLen = 0;
        while (!queue.isEmpty()) {
            for (int i = 1; i <= curLen; ++i) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    nextLen++;
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    nextLen++;
                }
                done.add(tmp.val);
            }
            stack.push(new ArrayList<Integer>(done));
            done.clear();
            curLen = nextLen;
            nextLen = 0;
        }
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}
