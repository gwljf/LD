package ListNode;

import Basic_Structue.ListNode;

/**
 * Created by wlf on 9/28/14.
 */
/*

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

        If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

        You may not alter the values in the nodes, only nodes itself may be changed.

        Only constant memory is allowed.

        For example,
        Given this linked list: 1->2->3->4->5

        For k = 2, you should return: 2->1->4->3->5

        For k = 3, you should return: 3->2->1->4->5
*/


public class Reverse_Nodes_in_k_Group {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode ret = reverseKGroup(l1, 2);
        ret.print();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        int n = 1;
        ListNode pre = dummyhead;
        ListNode cur = head;
        ListNode next;
        ListNode nhead;
        while (cur != null) {
            while (cur.next != null && n < k) {       // cur.next!=null 因为想走到最后一个有元的点,而不是走到null
                cur = cur.next;
                ++n;
            }
            if (n == k) {
                next = cur.next;
                cur.next = null;
                nhead = reverse(pre.next);

                pre.next = nhead;
                while (nhead.next != null) {        // nhead.next!=null  都是意味着走到最后一个元素,而不是结尾的null
                    nhead = nhead.next;
                }
                nhead.next = next;
                pre = nhead;
                cur = next;
                n = 1;
            } else {
                break;
            }
        }
        return dummyhead.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode nhead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = cur;
            cur = cur.next;
            node.next = null;
            node.next = nhead;
            nhead = node;
        }
        return nhead;
    }
}
