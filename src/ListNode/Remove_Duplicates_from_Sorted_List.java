package ListNode;

import Basic_Structue.ListNode;

/**
 * Created by wlf on 9/11/14.
 */



public class Remove_Duplicates_from_Sorted_List {

    /*Given a sorted linked list, delete all duplicates such that each element appear only once.

        For example,
        Given 1->1->2, return 1->2.
        Given 1->1->2->3->3, return 1->2->3.
    */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode l1 = head, l2 = head.next;

        while (l2 != null) {
            if (l1.val == l2.val) {
                l1.next = l2.next;
            } else {
                l1 = l1.next;
            }
            l2 = l2.next;
        }
        return head;
    }
    /*
        Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

        For example,
        Given 1->2->3->3->4->4->5, return 1->2->5.
        Given 1->1->1->2->3, return 2->3.
    */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        ListNode next = head.next;
        boolean dup = false;

        while (next != null) {
            if (cur.val == next.val) {
                dup = true;
                next = next.next;
            } else {
                if (dup) {
                    pre.next = next;
                    cur = next;
                    next = next.next;
                    dup = false;
                } else {
                    pre = pre.next;
                    cur = cur.next;
                    next = next.next;
                }
            }
        }
        if (dup) {
            pre.next = next;
        }
        return dummyHead.next;
    }
}
