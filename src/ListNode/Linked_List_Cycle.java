package ListNode;

import Basic_Structue.ListNode;

/**
 * Created by wlf on 9/11/14.
 */
public class Linked_List_Cycle {
    public static void main (String[] args) {
        ListNode circle = generateCircle();
        ListNode nonCircle = generateNonCircle();

        System.out.println(hasCycle(circle));
        System.out.println(hasCycle(nonCircle));
        System.out.println(detectCycle(circle).val);
        System.out.println(detectCycle(nonCircle));
    }

    public static boolean hasCycle(ListNode head) {
        if (head==null || head.next==null){
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        boolean hasCircle = false;
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCircle = true;
                break;
            }
        }
        if (!hasCircle) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static ListNode generateCircle () {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l1;
        return l1;
    }

    public static ListNode generateNonCircle () {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        return l1;
    }
}
