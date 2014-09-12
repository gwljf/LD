package ListNode;

import Basic_Structue.RandomListNode;

/**
 * Created by wlf on 9/11/14.
 */
public class CopyRandomList {
    public static void main (String[] args) {

    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }

        RandomListNode cur = head;
        RandomListNode copyCur = null;
        RandomListNode copyHead = null;

        while (cur != null) {
            copyCur = new RandomListNode(cur.label);
            if (copyHead == null) {
                copyHead = copyCur;
            }
            copyCur.next = cur.next;
            cur.next = copyCur;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            cur.next.random = cur.random==null ? null:cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            copyCur = cur.next;
            cur.next = cur.next.next;
            copyCur.next = cur.next==null ? null:cur.next.next;
            cur = cur.next;
        }

        return copyHead;

    }
}
