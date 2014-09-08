package BinaryTree_Traversal;

import Basic_Structue.ListNode;
import Basic_Structue.TreeNode;

import java.util.List;

/**
 * Created by wlf on 9/8/14.
 */
public class Convert_ArrayOrList_BST {
    public static void main (String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9,10};
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        n1.next=n2; n2.next=n3; n3.next=n4; n4.next=n5; n5.next=n6; n6.next=n7; n7.next=n8; n8.next=n9; n9.next=n10;

        TreeNode root1 = sortedArrayToBST(num);
        TreeNode root2 = sortedListToBST(n1);

        Traversal.inOrder(root1);
        System.out.println();
        Traversal.inOrder(root2);
    }

    public static TreeNode sortedArrayToBST(int[] num) {
        return builArraydBST(num, 0, num.length-1);
    }

    public static TreeNode builArraydBST (int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(num[(start+end)/2]);
        node.left = builArraydBST(num, start, (start+end)/2-1);
        node.right = builArraydBST(num, (start+end)/2+1, end);
        return node;
    }

    public static TreeNode sortedListToBST(ListNode head) {
        return buildListBST(head);
    }

    public static TreeNode buildListBST (ListNode node) {
        if (node == null) {
            return null;
        }
        if(node.next==null){                        // very important
            return new TreeNode(node.val);
        }
        ListNode fast = node, slow = node, firstEnd = node;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            firstEnd = slow;
            slow = slow.next;
        }
        ListNode first = node;
        firstEnd.next = null;
        TreeNode treeNode = new TreeNode(slow.val);
        ListNode second = slow.next;
        treeNode.left = buildListBST(first);
        treeNode.right = buildListBST(second);
        return treeNode;
    }
}
