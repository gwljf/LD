package ListNode;

import Basic_Structue.ListNode;

import java.util.List;

/**
 * Created by wlf on 9/8/14.
 */
public class Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode ret = addTwoNumbers(l1, l2);
        while (ret != null) {
            System.out.print(ret.val + "->");
            ret = ret.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        ListNode tmpL1 = l1, tmpL2 = l2;
        int carry = 0;
        while (tmpL1 != null && tmpL2 != null) {
            if (tmpL1.val + tmpL2.val + carry > 9) {
                cur.next = new ListNode((tmpL1.val + tmpL2.val + carry) % 10);
                carry = (tmpL1.val + tmpL2.val + carry) / 10;
            } else {
                cur.next = new ListNode(tmpL1.val + tmpL2.val + carry);
                carry = 0;
            }
            cur = cur.next;
            tmpL1 = tmpL1.next;
            tmpL2 = tmpL2.next;
        }

        while (tmpL1 != null) {
            if (tmpL1.val + carry > 9) {
                cur.next = new ListNode((tmpL1.val + carry) % 10);
                carry = (tmpL1.val + carry) / 10;
            } else {
                cur.next = new ListNode(tmpL1.val + carry);
                carry = 0;
            }
            cur = cur.next;
            tmpL1 = tmpL1.next;
        }

        while (tmpL2 != null) {
            if (tmpL2.val + carry > 9) {
                cur.next = new ListNode((tmpL2.val + carry) % 10);
                carry = (tmpL2.val + carry) / 10;
            } else {
                cur.next = new ListNode(tmpL2.val + carry);
                carry = 0;
            }
            cur = cur.next;
            tmpL2 = tmpL2.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        return dummyHead.next;

    }

}
