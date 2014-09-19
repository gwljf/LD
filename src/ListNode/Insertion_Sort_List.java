package ListNode;

import Basic_Structue.ListNode;

import java.util.List;

/**
 * Created by wlf on 9/19/14.
 */
public class Insertion_Sort_List {
    public static void main (String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode ret = insertionSortList(l1);
        while (ret!=null){
            System.out.print(ret.val+"->");
            ret = ret.next;
        }
    }
    public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = head;
        ListNode pre = dummyHead;
        ListNode ncur = pre.next;
        while(cur!=null){
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = null;
            while(true){
                if(ncur==null){
                    pre.next = tmp;
                    break;
                } else if (tmp.val>ncur.val) {
                    pre=pre.next;
                    ncur=ncur.next;
                } else {
                    pre.next = tmp;
                    tmp.next = ncur;
                    break;
                }
            }
            pre = dummyHead;
            ncur = pre.next;
        }
        return dummyHead.next;
    }
}
