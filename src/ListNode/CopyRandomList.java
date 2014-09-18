package ListNode;

import Basic_Structue.ListNode;
import Basic_Structue.RandomListNode;

/**
 * Created by wlf on 9/11/14.
 */
public class CopyRandomList {
    public static void main (String[] args) {
        RandomListNode l1 = new RandomListNode(1);
        RandomListNode l2 = new RandomListNode(2);
        RandomListNode l3 = new RandomListNode(3);
        RandomListNode l4 = new RandomListNode(4);
        RandomListNode l5 = new RandomListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        copyRandomList(l1);

    }

    public static RandomListNode copyRandomList(RandomListNode head) {
//        if (head == null){
//            return null;
//        }
//
//        RandomListNode cur = head;
//        RandomListNode copyCur = null;
//        RandomListNode copyHead = null;
//
//        while (cur != null) {
//            copyCur = new RandomListNode(cur.label);
//            if (copyHead == null) {
//                copyHead = copyCur;
//            }
//            copyCur.next = cur.next;
//            cur.next = copyCur;
//            cur = cur.next.next;
//        }
//
//        cur = head;
//        while (cur != null) {
//            cur.next.random = cur.random==null ? null:cur.random.next;
//            cur = cur.next.next;
//        }
//
//        cur = head;
//        while (cur != null) {
//            copyCur = cur.next;
//            cur.next = cur.next.next;
//            copyCur.next = cur.next==null ? null:cur.next.next;
//            cur = cur.next;
//        }
//
//        return copyHead;

        if (head == null) {
            return null;
        }

        RandomListNode cur = head;

        RandomListNode copycur = null;
        RandomListNode copyhead = null;


        while (cur != null) {
            copycur = new RandomListNode(cur.label);
            if (copyhead == null) {
                copyhead = copycur;
            }
            copycur.next = cur.next;
            cur.next = copycur;
            cur = cur.next.next;
        }



        cur = head;

        while (cur != null) {
            cur.next.random = cur.random==null? null: cur.random.next;
            cur = cur.next.next;
        }

        cur = head;

        while (cur != null) {
            copycur = cur.next;
            cur.next = copycur.next;
            copycur.next = cur.next==null? null: cur.next.next;
            cur = cur.next;
        }

        return copyhead;
    }
}
