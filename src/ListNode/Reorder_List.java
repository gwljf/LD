package ListNode;

import Basic_Structue.ListNode;

/**
 * Created by wlf on 9/10/14.
 */
public class Reorder_List {
/*

    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    You must do this in-place without altering the nodes' values.

    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head, slow = head, firstEnd = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            firstEnd = slow;
            slow = slow.next;
        }
        firstEnd.next = null;
        ListNode first = head, second = reverse(slow);
        ListNode dummyhead = new ListNode(-1);
        ListNode cur = dummyhead;
        boolean odd = true;
        while (first != null && second != null) {
            if (odd) {
                cur.next = first;
                first = first.next;
                cur = cur.next;
                cur.next = null;
                odd = false;
            } else {
                cur.next = second;
                second = second.next;
                cur = cur.next;
                cur.next = null;
                odd = true;
            }
        }
        cur.next = second;
        head = dummyhead.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode nhead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = nhead;
            nhead = tmp;
        }
        return nhead;
    }

}
