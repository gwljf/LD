package ListNode;

import Basic_Structue.ListNode;

/**
 * Created by wlf on 9/11/14.
 */
public class Merge_Two_Sorted_Lists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);

        ListNode ret = mergeTwoLists(l1, l2);

        ret.print();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode cur1 = l1, cur2 = l2;
        ListNode dummyHead = new ListNode(-1), cur = dummyHead;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
            cur.next = null;
        }

        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }

        return dummyHead.next;
    }

}
