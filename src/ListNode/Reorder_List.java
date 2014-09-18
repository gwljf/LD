package ListNode;

import Basic_Structue.ListNode;

/**
 * Created by wlf on 9/10/14.
 */
public class Reorder_List {
    public static void main(String[] args) {

    }

    public static void reorderList(ListNode head) {
        if (head==null || head.next==null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode firstEnd = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            firstEnd = slow;
            slow = slow.next;
        }
        firstEnd.next = null;
        ListNode reSecond = reverse(slow);
        ListNode l1 = head, l2 = reSecond;

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        boolean isOdd = false;

        while (l1 != null && l2 != null) {
            if (isOdd) {
                cur.next = l2;
                l2 = l2.next;
                isOdd = false;
            } else {
                cur.next = l1;
                l1 = l1.next;
                isOdd = true;
            }
            cur = cur.next;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        head = dummyHead.next;
    }

    public static ListNode reverse (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rehead = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode pre = cur;
            cur = cur.next;
            pre.next = rehead;
            rehead = pre;
        }

        return rehead;
    }

}
