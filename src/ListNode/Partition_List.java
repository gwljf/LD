package ListNode;

import Basic_Structue.ListNode;

/**
 * Created by wlf on 9/12/14.
 */

/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

        You should preserve the original relative order of the nodes in each of the two partitions.

        For example,
        Given 1->4->3->2->5->2 and x = 3,
        return 1->2->2->4->3->5.
*/

public class Partition_List {

    public static void main (String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l1.next = l2;
        ListNode l = partition(l1,2);
        while (l!=null) {
            System.out.print(l.val+"->");
            l = l.next;
        }
//        System.out.println(Linked_List_Cycle.hasCycle(l));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode cur1 = dummyHead1;
        ListNode cur2 = dummyHead2;

        ListNode cur = head;

        while (cur!=null) {
            if (cur.val < x) {
                cur1.next = cur;
                cur = cur.next;
                cur1 = cur1.next;
                cur1.next = null;
            } else {
                cur2.next = cur;
                cur = cur.next;
                cur2 = cur2.next;
                cur2.next = null;
            }
        }

        cur1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
